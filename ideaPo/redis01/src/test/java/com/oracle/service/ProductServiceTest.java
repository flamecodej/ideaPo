package com.oracle.service;

import com.oracle.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testProductList(){
        List<Product> list = this.productService.findAll();
        System.out.println(list);
    }

    @Test
    public void testHashProduct(){
        System.out.println(this.productService.getProById(8));
    }

    @Test
    public void testAdd(){
        Product product = new Product();
        product.setProname("asdasdasd");
        this.productService.insertPro(product);
    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setId(8);
        product.setProname("aaa");
        this.productService.updatePro(product);
    }

    @Test
    public void testDel(){
        this.productService.delPro(8);
    }

}
