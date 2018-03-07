package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.ArticleEntity;

import java.util.List;

/**
 * @author GeekYe
 * @Description: ArticleService
 * @Date 2018 /03/07
 */
public interface ArticleService {


    /**
     * List articles at home list.
     *
     * @return the list
     */
    List<ArticleEntity> listArticlesAtHome();


    /**
     * List articles by category list. 弃用
     *
     * @param category the category
     * @return the list
     */
    List<ArticleEntity> listArticlesByCategory(String category);


    /**
     * Count pagination bycategory integer.
     *
     * @param category the category
     * @return the integer
     */
    Integer countPaginationByCategory(String category);

    /**
     * List articles by pagination list.
     *
     * @param category the category
     * @param page     the page
     * @return the list
     */
    List<ArticleEntity> listArticlesByPagination(String category, Integer page);


    /**
     * List articles by obscure list.
     *
     * @param field the field
     * @return the list
     */
    List<ArticleEntity> listArticlesByObscure(String field);

    /**
     * List articles at admin home list.
     *
     * @param page the page
     * @return the list
     */
    List<ArticleEntity> listArticlesAtAdminHome(Integer page);


    /**
     * Count admin pagination by category integer.弃用
     *
     * @param category the category
     * @return the integer
     */
    Integer countAdminPaginationByCategory(String category);

    /**
     * Save article.
     *
     * @param articleEntity the article entity
     */
    void saveArticle(ArticleEntity articleEntity);

    /**
     * Delete article.
     *
     * @param articleId the article id
     */
    void deleteArticle(Integer articleId);


    /**
     * List articles at admin by time list.
     *
     * @param method   the method
     * @param page     the page
     * @param category the category
     * @return the list
     */
    List<ArticleEntity> listArticlesAtAdminByTime(String method, Integer page, String category);

    /**
     * Gets article by id.
     *
     * @param articleId the article id
     * @return the article by id
     */
    ArticleEntity getArticleById(Integer articleId);

    /**
     * Gets article by id not md.
     *
     * @param articleId the article id
     * @return the article by id not md
     */
    ArticleEntity getArticleByIdNotMD(Integer articleId);

    /**
     * Update article.
     *
     * @param articleId       the article id
     * @param articleCategory the article category
     * @param articleTitle    the article title
     * @param articleContent  the article content
     */
    void updateArticleById(Integer articleId, String articleCategory,
                       String articleTitle, String articleContent);

    /**
     * Gets article by direction.
     *
     * @param direction the direction
     * @param articleId the article id
     * @return the article by direction
     */
    Integer getArticleByDirection(String direction, Integer articleId);
}
