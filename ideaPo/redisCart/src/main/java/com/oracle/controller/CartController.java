package com.oracle.controller;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.ResponseEntity;
import com.oracle.pojo.Cart;
import com.oracle.pojo.Product;
import com.oracle.pojo.Users;
import com.oracle.service.CartService;
import com.oracle.service.ProService;
import com.oracle.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String COOKIES_CART_NAME = "cartList";

    @Autowired
    private ProService proService;

    @Autowired
    private CartService cartService;


    @RequestMapping("/add")
    public @ResponseBody
    ResponseEntity add(Integer id, HttpServletRequest request, HttpServletResponse response){
        Product product = this.proService.getProById(id);
        if(request.getSession().getAttribute("userInfo")==null){
            // 用户没有登录时 将保存 cookie
            String cookies = CookieUtil.getCookieValue(request,COOKIES_CART_NAME,true);
            if(cookies==null){
                Cart cart = new Cart();
                cart.setId(id);
                cart.setNum(1);
                cart.setProduct(product.getId());
                cart.setPrice(product.getProPrice());
                cart.setGoodsimg(product.getProImg());
                cart.setGoodsname(product.getProFullname());
                List<Cart> cookieListCart = new ArrayList<>();
                cookieListCart.add(cart);
                String cookiesJson = JSON.toJSONString(cookieListCart);
                CookieUtil.setCookie(request,response,COOKIES_CART_NAME,cookiesJson,3600*24*7,true);
                return new ResponseEntity(200);
            }else{
                // 有cookie时 进行转换为cookie 对象  进行遍历
                List<Cart> cartList = JSON.parseArray(cookies,Cart.class);
                for (int i = 0; i <cartList.size() ; i++) {
                    if(product.getId().equals(cartList.get(i).getId())){
                        cartList.get(i).setNum(cartList.get(i).getNum()+1);
                        cookies = JSON.toJSONString(cartList);
                        CookieUtil.setCookie(request,response,COOKIES_CART_NAME,cookies,3600*24*7,true);
                        return new ResponseEntity(200);
                    }
                }
                Cart cart = new Cart();
                cart.setId(id);
                cart.setNum(1);
                cart.setProduct(product.getId());
                cart.setPrice(product.getProPrice());
                cart.setGoodsimg(product.getProImg());
                cart.setGoodsname(product.getProFullname());
                cartList.add(cart);
                cookies = JSON.toJSONString(cartList);
                CookieUtil.setCookie(request,response,COOKIES_CART_NAME,cookies,3600*24*7,true);
                return new ResponseEntity(200);
            }
        }else{
            Users user = (Users) request.getSession().getAttribute("userInfo");
            if(this.cartService.addToRedis(id,user.getLoginName())){
                return new ResponseEntity(200);
            }
        }
        return null;
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model){
        if(request.getSession().getAttribute("userInfo")==null){
            String cookieJson = CookieUtil.getCookieValue(request,COOKIES_CART_NAME,true);
            List<Cart> cookieCartList = JSON.parseArray(cookieJson,Cart.class);
            model.addAttribute("cartList",cookieCartList);
            return "/cart/list";
        }
        List<Cart> redisCartList = this.cartService.list(((Users)request.getSession().getAttribute("userInfo")).getLoginName());
        model.addAttribute("cartList",redisCartList);
        return "/cart/list";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ResponseEntity modify(Integer cartId,Integer edit,Integer cartNum,HttpServletRequest request, HttpServletResponse response){
        Product product = this.proService.getProById(cartId);
        if(request.getSession().getAttribute("userInfo")==null){
            // 用户没有登录时 将保存 cookie
            String cookies = CookieUtil.getCookieValue(request,COOKIES_CART_NAME,true);
            List<Cart> cartList = JSON.parseArray(cookies,Cart.class);
            for (int i = 0; i <cartList.size() ; i++) {
                if(product.getId().equals(cartList.get(i).getId())){
                    if(edit==1){
                        cartList.get(i).setNum(cartList.get(i).getNum()-1);
                        if(cartList.get(i).getNum()==0){
                            cartList.remove(cartList.get(i));
                        }
                    }
                    if(edit==0){
                        cartList.get(i).setNum(cartList.get(i).getNum()+1);
                    }
                    if(edit==2){
                        cartList.get(i).setNum(cartNum);
                    }
                    cookies = JSON.toJSONString(cartList);
                    CookieUtil.setCookie(request,response,COOKIES_CART_NAME,cookies,3600*24*7,true);
                    return new ResponseEntity(200);
                }
            }
        }else{
            Users user = (Users) request.getSession().getAttribute("userInfo");
            if(this.cartService.editToRedis(cartId,edit,cartNum,user.getLoginName())){
                return new ResponseEntity(200);
            }
        }
        return null;
    }

}
