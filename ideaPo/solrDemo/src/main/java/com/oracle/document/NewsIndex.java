package com.oracle.document;

import org.apache.solr.client.solrj.beans.Field;

public class NewsIndex {    // 一个需要  索引的  新闻数据

    // 在进行 词汇检索后  返回的数据中包含的ID
    // 在业务使用时  通过返回的Id 在根据这个ID 进行 详细的数据的获取
    @Field
    private Integer id;  //与数据库的id 是一致的  精确查询  获取的是  静态页面
    //  通过一个新闻详细信息的地址 和 id  进行前往这个新闻 详情页
    // http://news.com/453.html  不需要 经过 jsp 中编译
    // url xxxxx/2335.html(基本上不会发生变动)
    // 概要信息
    // 当一个用户  不知道具体的一个产品信息情况时 需要搜索[模糊]
    // 根据 词汇 进行匹配度查询(多条 简要的数据  放在页面上展示[根据词汇的 字或词  高亮显示])
    // 用户根据返回的数据 查看是否包含想要的数据 ,如果有，就会根据这个词条 的连接，进入这个 信息详细页面
    @Field
    private String title;

    public NewsIndex() {
    }

    public NewsIndex(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
