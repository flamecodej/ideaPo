package com.oracle.run;

import com.oracle.pojo.News;
import com.oracle.service.NewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-root.xml");
        NewsService newsService = (NewsService) ac.getBean("newsServiceApi");
        News news = newsService.getNewsById(99);
        System.out.println(news);
        /*News news = new News();
        news.setId(1900);
        news.setTitle("save_Test");
        news.setContent("save_C");
        news.setEditDate(new Date());
        newsService.save(news);*/

        // tomcat  进行  发布    一个  应用  多个应用

        // dubbo  在进行 服务注册 时  根据 注册中心  获取 的地址  可以在 本地 进行要给缓存
    }
}
