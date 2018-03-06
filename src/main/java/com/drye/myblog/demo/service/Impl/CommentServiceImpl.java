package com.drye.myblog.demo.service.Impl;

import com.drye.myblog.demo.entity.CommentEntity;
import com.drye.myblog.demo.mapper.CommentMapper;
import com.drye.myblog.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: commentService接口的实现类
 * @author: GeekYe
 * @create: 2018-03-04 15:06
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void saveComment(String commentName, String commentEmail, String commentContent, Integer articleId) {
        String commentTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        commentMapper.saveComment(commentName,commentEmail,commentContent,commentTime,articleId);
    }

    @Override
    public List<CommentEntity> listComment(Integer articleId) {
        return commentMapper.listComment(articleId);
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentMapper.deleteComment(commentId);
    }
}
