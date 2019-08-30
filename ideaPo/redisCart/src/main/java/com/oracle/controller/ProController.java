package com.oracle.controller;

import com.oracle.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProController {

    @Autowired
    private ProService proService;

    @RequestMapping("product")
    public String getProById(Integer goodsId, Model model){
        model.addAttribute("product",this.proService.getProById(goodsId));
        return "/product/product";
    }
}
