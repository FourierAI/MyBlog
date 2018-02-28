package com.drye.myblog.demo.entity;

import java.util.Date;

public class CommentEntity {
    private Integer commentId;
    private String commentName;
    private String commentEmail;
    private String commentContent;
    private Date commentTime;
    private Integer articleId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

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
                ", articleId=" + articleId +
                '}';
    }
}
