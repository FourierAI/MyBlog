package com.drye.myblog.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The type Article service test.
 *
 * @program: MyBlogVersion1
 * @description: ArticleService的测试类
 * @author: GeekYe
 * @create: 2018 -03-05 20:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    /**
     * Sets article service.
     *
     * @param articleService the article service
     */
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}
