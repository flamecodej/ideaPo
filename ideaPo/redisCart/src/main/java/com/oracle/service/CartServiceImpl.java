package com.oracle.service;

import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Cart;
import com.oracle.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private static final String COOKIES_CART_NAME = "cart:";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<Cart> list(String loginName) {
        final String CACHE_KEY = COOKIES_CART_NAME + "list";
        return (List<Cart>) this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName);
    }

    @Override
    public boolean addToRedis(Integer id, String loginName) {
        final String CACHE_KEY = COOKIES_CART_NAME + "list";
        List<Cart> redisCartList = null;
        Product product = this.productMapper.selectByPrimaryKey(id);
        if(this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName)==null){
            // redis中没有值
            Cart cart = new Cart();
            cart.setId(id);
            cart.setNum(1);
            cart.setProduct(product.getId());
            cart.setPrice(product.getProPrice());
            cart.setGoodsimg(product.getProImg());
            cart.setGoodsname(product.getProFullname());
            redisCartList = new ArrayList<>();
            this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,redisCartList);
            return true;
        }else{
            redisCartList = (List<Cart>) this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName);
            for (int i = 0; i < redisCartList.size(); i++) {
                if(product.getId().equals(redisCartList.get(i).getId())){
                    redisCartList.get(i).setNum(redisCartList.get(i).getNum()+1);
                    this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,redisCartList);
                    return true;
                }
            }
            Cart cart = new Cart();
            cart.setId(id);
            cart.setNum(1);
            cart.setProduct(product.getId());
            cart.setPrice(product.getProPrice());
            cart.setGoodsimg(product.getProImg());
            cart.setGoodsname(product.getProFullname());
            redisCartList.add(cart);
            this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,redisCartList);
            return true;
        }
    }

    @Override
    public boolean editToRedis(Integer cartId, Integer edit, Integer cartNum,String loginName) {
        final String CACHE_KEY = COOKIES_CART_NAME + "list";
        List<Cart> redisCartList = null;
        Product product = this.productMapper.selectByPrimaryKey(cartId);
        redisCartList = (List<Cart>) this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName);
        for (int i = 0; i < redisCartList.size(); i++) {
            if(product.getId().equals(redisCartList.get(i).getId())){
                if(edit==1){
                    redisCartList.get(i).setNum(redisCartList.get(i).getNum()-1);
                    if(redisCartList.get(i).getNum()==0){
                        redisCartList.remove(i);
                    }
                }
                if(edit==0){
                    redisCartList.get(i).setNum(redisCartList.get(i).getNum()+1);
                }
                if(edit==2){
                    redisCartList.get(i).setNum(cartNum);
                }
                this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,redisCartList);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean merge(List<Cart> cookieCartList, String loginName) {
        // 合并购物车 时 需要两个 list 集合
        final String CACHE_KEY = COOKIES_CART_NAME + "list";
        if(this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName)==null){
            this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,cookieCartList);
            return true;
        }
        List<Cart> redisCartList = (List<Cart>) this.redisTemplate.boundHashOps(CACHE_KEY).get(loginName);
        // 不能简单合并 list.addAll
        redisCartList = this.merge(redisCartList,cookieCartList);
        this.redisTemplate.boundHashOps(CACHE_KEY).put(loginName,redisCartList);
        return true;
    }
    
    private List<Cart> merge(List<Cart> cookiesCartList,List<Cart> redisCartList){
        for (int i = 0; i < redisCartList.size(); i++) {
            for (int j = 0; j < cookiesCartList.size(); j++) {
                if(redisCartList.get(i).getProduct().equals(cookiesCartList.get(j).getProduct())){
                    redisCartList.get(i).setNum(redisCartList.get(i).getNum()+cookiesCartList.get(j).getNum());
                    cookiesCartList.remove(cookiesCartList.get(j));
                    break;
                }
            }
        }
        redisCartList.addAll(cookiesCartList);
        return redisCartList;
    }
}
