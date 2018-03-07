package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.CommentEntity;

import java.util.List;


/**
 * @author GeekYe
 * @Description:
 * @Date 2018 /03/07
 */
public interface CommentService {


    /**
     * Save comment By articleId.
     *
     * @param commentName    the comment name
     * @param commentEmail   the comment email
     * @param commentContent the comment content
     * @param articleId      the article id
     */
    void saveComment(String commentName, String commentEmail,
                     String commentContent, Integer articleId);

    /**
     * List comment list.
     *
     * @param articleId the article id
     * @return the list
     */
    List<CommentEntity> listComment(Integer articleId);

    /**
     * Delete comment.
     *
     * @param commentId the comment id
     */
    void deleteComment(Integer commentId);
}
