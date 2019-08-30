package com.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CommonController {

    @RequestMapping("/common/main")
    public String main(){

        return "/admin/comm/main";
    }
}
