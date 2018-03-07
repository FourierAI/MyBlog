package com.drye.myblog.demo.entity;

/**
 * The type Article entity.
 *
 * @Description: ArticleEntity实体类
 * @Author: GeekYe
 * @Date: 2018 /3/7
 */
public class ArticleEntity {

    private Integer articleId;
    private String articleCategory;
    private String articleTitle;
    private String articleContent;
    private String articleTime;


    /**
     * Gets article id.
     *
     * @return the article id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * Sets article id.
     *
     * @param articleId the article id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets article category.
     *
     * @return the article category
     */
    public String getArticleCategory() {
        return articleCategory;
    }

    /**
     * Sets article category.
     *
     * @param articleCategory the article category
     */
    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    /**
     * Gets article title.
     *
     * @return the article title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets article title.
     *
     * @param articleTitle the article title
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets article content.
     *
     * @return the article content
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * Sets article content.
     *
     * @param articleContent the article content
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * Gets article time.
     *
     * @return the article time
     */
    public String getArticleTime() {
        return articleTime;
    }

    /**
     * Sets article time.
     *
     * @param articleTime the article time
     */
    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    /**
     * Instantiates a new Article entity.
     */
    public ArticleEntity() {
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "articleId=" + articleId +
                ", articleCategory='" + articleCategory + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleTime=" + articleTime +
                '}';
    }
}
