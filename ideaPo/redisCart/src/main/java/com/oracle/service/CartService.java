package com.oracle.service;

import com.oracle.pojo.Cart;

import java.util.List;

public interface CartService {

    boolean merge(List<Cart> cookieCartList, String loginName);

    List<Cart> list(String loginName);

    boolean addToRedis(Integer id, String loginName);

    boolean editToRedis(Integer cartId,Integer edit,Integer cartNum,String loginName);
}
