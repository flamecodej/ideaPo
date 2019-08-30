package com.oracle.service;

import com.oracle.pojo.Product;

import java.util.List;

public interface ProService {

    List<Product> list();

    Product getProById(Integer goodsId);
}
