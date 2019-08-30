package com.oracle.test;

import com.oracle.document.NewsIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:solr.xml")
public class SolrTest {

    // solr ES elasticSearch
    @Autowired
    private SolrTemplate solrTemplate;


    @Test
    public void Test(){
        /*List<String> list = Arrays.asList("a","b","c");
        list.remove(0);*/
        parse();
    }

    private static void parse(){
        int a=0,c=0;
        do {
            --c;
            a=a-1;
        }while (a>0);
        System.out.println(c);
    }

    @Test
    public void addIndex(){
        NewsIndex newsIndex = new NewsIndex();
        newsIndex.setId(2);
        newsIndex.setTitle("唐僧终究还是娶了女儿国国王,台风");
        solrTemplate.saveBean(newsIndex);
        solrTemplate.commit();
    }

    /**
     * 用户 在输入框 中 没有输入  关键字
     */
    @Test
    public void getNews(){
        // 参数 进行判断
        Query solrDataQuery=new SimpleQuery("*:*");
        //Criteria criteria=new Criteria("title").is("唐僧");
       /* Criteria filterCrit=new Criteria("xinxin_price");
        filterCrit.greaterThanEqual(new BigDecimal(7000));
        FilterQuery filterQuery=new SimpleFilterQuery(filterCrit);*/
        //solrDataQuery.addCriteria(criteria);
        /*solrDataQuery.addFilterQuery(filterQuery);*/
        solrDataQuery.setOffset(1);// offset 从哪开始取  rows==length
        solrDataQuery.setRows(2);
        ScoredPage<NewsIndex> page= solrTemplate.queryForPage(solrDataQuery,NewsIndex.class);
        System.out.println(page.getSize());
        List<NewsIndex> ls=page.getContent();
        System.out.println(ls.size());
        for (NewsIndex l : ls) {
            System.out.println(l.getTitle());
        }
    }

    @Test
    public void highly(){
        HighlightQuery HighlightQuery=new SimpleHighlightQuery();
        HighlightOptions highlightOptions=new HighlightOptions().addField("title");
        highlightOptions.setSimplePrefix("<em style='color:red'>");//高亮前缀
        highlightOptions.setSimplePostfix("</em>");//高亮后缀
        HighlightQuery.setHighlightOptions(highlightOptions);//设置高亮选项
        Criteria criteria=new Criteria("title").is("风");
        HighlightQuery.addCriteria(criteria);
        HighlightPage<NewsIndex> page=solrTemplate.queryForHighlightPage(HighlightQuery,NewsIndex.class);
        for(HighlightEntry<NewsIndex> entry:page.getHighlighted()){
            NewsIndex news= entry.getEntity();
            if(entry.getHighlights().size()>0&&entry.getHighlights().get(0).getSnipplets().size()>0){
                news.setTitle(entry.getHighlights().get(0).getSnipplets().get(0));
            }
        }
        List<NewsIndex> ls=page.getContent();
        for (NewsIndex n : ls) {
            System.out.println(n.getTitle());
        }
    }



}
