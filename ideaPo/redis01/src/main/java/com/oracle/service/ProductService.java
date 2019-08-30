package com.oracle.service;

import com.oracle.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product getProById(Integer id);

    void insertPro(Product product);

    void updatePro(Product product);

    void delPro(Integer id);
}
