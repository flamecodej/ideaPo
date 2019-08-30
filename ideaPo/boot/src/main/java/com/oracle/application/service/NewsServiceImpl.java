package com.oracle.application.service;

import com.oracle.application.mapper.NewsMapper;
import com.oracle.application.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    private NewsMapper newsMapper;

    @Override
    public List<News> list() {
        return this.newsMapper.selectByExample(null);
    }
}
