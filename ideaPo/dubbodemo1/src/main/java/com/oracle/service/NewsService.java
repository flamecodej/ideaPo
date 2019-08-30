package com.oracle.service;

import com.oracle.pojo.News;

public interface NewsService {

    void save(News news);

    News getNewsById(Integer id);
}
