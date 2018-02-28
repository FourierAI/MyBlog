package com.drye.myblog.demo.entity;

import java.sql.Date;

public class ReplyEntity {
    private Integer replyId;
    private String replyContent;
    private Date replyTime;
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "ReplyEntity{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                ", commentId=" + commentId +
                '}';
    }
}
