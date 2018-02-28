package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.ArticleEntity;
import com.drye.myblog.demo.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }
    @Test
    public void findHomeTest(){
        List<ArticleEntity> articleEntityList= (List<ArticleEntity>) articleMapper.findHome();
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.toString());
        }
    }
    @Test
    public void addArticles() {
        for (int i = 0; i < 20; i++) {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setArticleTitle("日微软");
            articleEntity.setArticleContent(UtilRandom.RandomString());
            articleEntity.setArticleCategory("生活关于我");
            articleEntity.setArticleTime(df.format(date));
            articleMapper.addArticle(articleEntity.getArticleCategory(), articleEntity.getArticleTitle(), articleEntity.getArticleContent(), articleEntity.getArticleTime());
        }
    }
    @Test
    public void pagination(){
        System.out.println(articleMapper.articlePagination("摄影|电影"));
    }
    @Test
    public void findByPagination(){
        List<ArticleEntity> articleEntityList=articleService.findByPagination("摄影电影",1);
        for (ArticleEntity art:articleEntityList
             ) {
            System.out.println(art);
        }
    }
    @Test
    public void findByObscureTest(){
        String str="框架";
        List<ArticleEntity> articleEntityList=articleMapper.findByObscure(str);
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.toString());
        }
    }
    @Test
    public void findAtAdminHome(){
        List<ArticleEntity> articleEntityList=articleMapper.findAtAdminHome(0);
        for (ArticleEntity a:articleEntityList
             ) {
            System.out.println(a.getArticleTime());
        }

    }
    @Test
    public void adminPagination(){
        System.out.println(articleMapper.adminPagination());
    }
    @Test
    public void deleteArticle(){
        articleMapper.deleteArticle(249);
    }
}

