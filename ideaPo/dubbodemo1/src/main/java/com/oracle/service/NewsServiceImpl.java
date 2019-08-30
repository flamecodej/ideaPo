package com.oracle.service;

import com.oracle.pojo.News;

import java.util.Date;

public class NewsServiceImpl implements NewsService {
    public void save(News news) {
        System.out.println("新闻的执行保存::"+news);
    }

    public News getNewsById(Integer id) {
        News news = new News();
        news.setId(id);
        news.setTitle("获取标题");
        news.setContent("获取的内容");
        news.setEditDate(new Date());
        return news;
    }
}
