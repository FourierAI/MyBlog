package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.ArticleEntity;
import com.drye.myblog.demo.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The type Article mapper test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;

    /**
     * Sets article mapper.
     *
     * @param articleMapper the article mapper
     */
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    /**
     * List articles at home test.
     */
    @Test
    public void listArticlesAtHomeTest(){
        List<ArticleEntity> articleEntityList= articleMapper.listArticlesAtHome();
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.toString());
        }
    }

    /**
     * Save article test.
     */
    @Test
    public void saveArticleTest() {
        for (int i = 0; i < 20; i++) {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setArticleTitle("日微软");
            articleEntity.setArticleContent(UtilRandom.RandomString());
            articleEntity.setArticleCategory("生活关于我");
            articleEntity.setArticleTime(df.format(date));
            articleMapper.saveArticle(articleEntity.getArticleCategory(), articleEntity.getArticleTitle(), articleEntity.getArticleContent(), articleEntity.getArticleTime());
        }
    }

    /**
     * Count pagination by category test.
     */
    @Test
    public void countPaginationByCategoryTest(){
        System.out.println(articleMapper.countPaginationByCategory("摄影|电影"));
    }

    /**
     * List articles by pagination test.
     */
    @Test
    public void listArticlesByPaginationTest(){
        List<ArticleEntity> articleEntityList=articleService.listArticlesByPagination("摄影电影",1);
        for (ArticleEntity art:articleEntityList
             ) {
            System.out.println(art);
        }
    }

    /**
     * List articles by obscure test.
     */
    @Test
    public void listArticlesByObscureTest(){
        String str="框架";
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesByObscure(str);
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.toString());
        }
    }

    /**
     * List articles at admin home test.
     */
    @Test
    public void listArticlesAtAdminHomeTest(){
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesAtAdminHome(0);
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.getArticleTime());
        }

    }

    /**
     * Count admin pagination by category test.
     */
    @Test
    public void countAdminPaginationByCategoryTest(){
        System.out.println(articleMapper.countAdminPaginationByCategory("编程软件"));
    }

    /**
     * Delete article test.
     */
    @Test
    public void deleteArticleTest(){
        articleMapper.deleteArticle(249);
    }

    /**
     * Find by time test.
     */
    @Test
    public void findByTimeTest(){
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesAtAdminByTime("asc",0,"编程软件");
        for (ArticleEntity articleEntity:articleEntityList
             ) {
            System.out.println(articleEntity.getArticleTime());
        }
    }

    /**
     * Get article by id test.
     */
    @Test
    public void getArticleByIdTest(){
        System.out.println(articleMapper.getArticleById(96).toString());

    }

    /**
     * Update article test.
     */
    @Test
    public void updateArticleTest(){
        articleMapper.updateArticleById(75,"测试","测试","测试");
    }

    /**
     * Conut before record test.
     */
    @Test
    public void conutBeforeRecordTest(){
        System.out.println(articleMapper.countBeforeRecord(75));
    }
}

