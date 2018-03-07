package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GeekYe
 * @Description:
 * @Date 2018 /03/07
 */
@Mapper
@Component
public interface ArticleMapper {

    /**
     * List articles at home list.
     *
     * @Description: 按照更新时间 ，显示主页的文章
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    List<ArticleEntity> listArticlesAtHome();

    /**
     * List articles by category list.
     *
     * @param category the category
     * @Description: 按种类查询 ，显示在各个分页上
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    List<ArticleEntity> listArticlesByCategory(@Param(value = "category") String category);

    /**
     * Save article.
     *
     * @param category the category
     * @param title    the title
     * @param content  the content
     * @param time     the time
     * @Description: 增加文章
     * @return: void
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    void saveArticle(@Param(value = "category") String category,
                     @Param(value = "title") String title,
                     @Param(value = "content") String content,
                     @Param(value = "time") String time);

    /**
     * Count pagination by category integer.
     *
     * @param category the category
     * @Description: 分页效果
     * @return: java.lang.Integer
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    Integer countPaginationByCategory(@Param(value = "category") String category);

    /**
     * List articles by pagination list.
     *
     * @param category the category
     * @param page     the page
     * @Description: 按索引分页查找文章
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    List<ArticleEntity> listArticlesByPagination(@Param(value = "category") String category,
                                                 @Param(value = "page") Integer page);

    /**
     * List articles by obscure list.
     *
     * @param field the field
     * @Description: 主页模糊查找
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /2/13
     */
    List<ArticleEntity> listArticlesByObscure(@Param(value = "field") String field);

    /**
     * List articles at admin home list.
     *
     * @param page the page
     * @Description: 根据page参数 ，分页显示文章列表信息
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /2/15
     */
    List<ArticleEntity> listArticlesAtAdminHome(@Param(value = "page") Integer page);

    /**
     * Count admin pagination by category integer.
     *
     * @param category the category
     * @Description: 分页效果
     * @return: java.lang.Integer
     * @Author: GeekYe
     * @Date: 2018 /2/16
     */
    Integer countAdminPaginationByCategory(@Param(value = "category") String category);

    /**
     * Delete article.
     *
     * @param articleId the article id
     * @Description: 根据前端传过来的articleId来删除文章
     * @return: void
     * @Author: GeekYe
     * @Date: 2018 /2/28
     */
    void deleteArticle(@Param(value = "articleId") Integer articleId);

    /**
     * List articles at admin by time list.
     *
     * @param method          the method
     * @param page            the page
     * @param articleCategory the article category
     * @Description: 通过时间排序
     * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
     * @Author: GeekYe
     * @Date: 2018 /3/1
     */
    List<ArticleEntity> listArticlesAtAdminByTime(@Param(value = "method") String method,
                                                  @Param(value = "page") Integer page,
                                                  @Param(value = "articleCategory") String articleCategory);

    /**
     * Gets article by id.
     *
     * @param articleId the article id
     * @Description: 通过Id获取文章详情
     * @return: com.drye.myblog.demo.entity.ArticleEntity
     * @Author: GeekYe
     * @Date: 2018 /3/3
     */
    ArticleEntity getArticleById(@Param(value = "articleId") Integer articleId);

    /**
     * Update article by id.
     *
     * @param articleId       the article id
     * @param articleCategory the article category
     * @param articleTitle    the article title
     * @param articleContent  the article content
     * @Description: 修改文章内容
     * @return: void
     * @Author: GeekYe
     * @Date: 2018 /3/4
     */
    void updateArticleById(@Param(value = "articleId") Integer articleId,
                           @Param(value = "articleCategory") String articleCategory,
                           @Param(value = "articleTitle") String articleTitle,
                           @Param(value = "articleContent") String articleContent);

    /**
     * Count before record integer.
     *
     * @param articleId the article id
     * @Description: 通过articleId查询之前有几条记录 ，来确定偏移量
     * @return: java.lang.Integer
     * @Author: GeekYe
     * @Date: 2018 /3/5
     */
    Integer countBeforeRecord(@Param(value = "articleId") Integer articleId);

    /**
     * Gets article id by limit.
     *
     * @param offest the offest
     * @Description: 通过偏移量查询articleId
     * @return: java.lang.Integer
     * @Author: GeekYe
     * @Date: 2018 /3/5
     */
    Integer getArticleIdByLimit(@Param(value = "offest") Integer offest);
}
