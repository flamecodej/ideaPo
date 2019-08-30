package com.oracle.application.controller;

import com.oracle.application.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//返回json
@RequestMapping("/news")
public class HomeController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/home")
    public String home(){
        return "SpringBoot";
    }



    // 当请求为 restFull 风格时  需要使用到的请求方式
    // http 请求时  不要加入 动词  get add.
    // 通过同一个url  根据 不同的请求方式  来决定 由那个请求处理
    // get- 获取  post-请求添加 put-请求更新  delete-删除
    // news/news [post]
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("newsList",this.newsService.list());
        return "home";
    }
}
