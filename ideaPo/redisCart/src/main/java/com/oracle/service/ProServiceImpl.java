package com.oracle.service;

import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return this.productMapper.selectByExample(null);
    }

    @Override
    public Product getProById(Integer goodsId) {
        return this.productMapper.selectByPrimaryKey(goodsId);
    }
}
