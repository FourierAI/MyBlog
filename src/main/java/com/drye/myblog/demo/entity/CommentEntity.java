package com.drye.myblog.demo.entity;

/**
 * The type Comment entity.
 *
 * @Description: CommentEntity实体类
 * @Author: GeekYe
 * @Date: 2018 /3/7
 */
public class CommentEntity {

    private Integer commentId;
    private String commentName;
    private String commentEmail;
    private String commentContent;
    private String commentTime;
    private ArticleEntity articleEntity;

    /**
     * Gets comment id.
     *
     * @return the comment id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * Sets comment id.
     *
     * @param commentId the comment id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * Gets comment name.
     *
     * @return the comment name
     */
    public String getCommentName() {
        return commentName;
    }

    /**
     * Sets comment name.
     *
     * @param commentName the comment name
     */
    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    /**
     * Gets comment email.
     *
     * @return the comment email
     */
    public String getCommentEmail() {
        return commentEmail;
    }

    /**
     * Sets comment email.
     *
     * @param commentEmail the comment email
     */
    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    /**
     * Gets comment content.
     *
     * @return the comment content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * Sets comment content.
     *
     * @param commentContent the comment content
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * Gets comment time.
     *
     * @return the comment time
     */
    public String getCommentTime() {
        return commentTime;
    }

    /**
     * Sets comment time.
     *
     * @param commentTime the comment time
     */
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * Gets article entity.
     *
     * @return the article entity
     */
    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    /**
     * Sets article entity.
     *
     * @param articleEntity the article entity
     */
    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    /**
     * Instantiates a new Comment entity.
     */
    public CommentEntity() {
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "commentId=" + commentId +
                ", commentName='" + commentName + '\'' +
                ", commentEmail='" + commentEmail + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime=" + commentTime +
                ", articleEntity=" + articleEntity +
                '}';
    }
}
