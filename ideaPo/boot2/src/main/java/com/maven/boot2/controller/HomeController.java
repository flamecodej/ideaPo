package com.maven.boot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "SpringBoot";
    }
}
