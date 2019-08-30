package com.oracle.controller;

import com.alibaba.fastjson.JSON;
import com.oracle.pojo.Cart;
import com.oracle.pojo.Users;
import com.oracle.service.CartService;
import com.oracle.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private CartService cartService;

    private static final String COOKIES_CART_NAME = "cartList";

    @RequestMapping("login")
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Users users = new Users();
        users.setId(1);
        users.setLoginName("aa");
        session.setAttribute("userInfo",users);
        //========判断  这个用户请求 中 cookie 是否存在
        String cookiesJson = CookieUtil.getCookieValue(request,COOKIES_CART_NAME,true);
        if(cookiesJson!=null){
            List<Cart> cookieCartList = JSON.parseArray(cookiesJson,Cart.class);
            cartService.merge(cookieCartList,users.getLoginName());
            return "";
        }
        // 登录后删除cookie
        CookieUtil.deleteCookie(request,response,COOKIES_CART_NAME);
        return "";
    }
}
