package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.CommentEntity;

import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: comment的Service层
 * @author: GeekYe
 * @create: 2018-03-04 14:58
 **/
public interface CommentService {
    /**
    * @Description:  通过controller传来的comment实体类增加数据
    * @Param: [commentName, commentEmail, commentContent, commentTime, articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    void saveComment(String commentName, String commentEmail,
                     String commentContent, Integer articleId);
    /**
    * @Description:  通过controller传来的articleId查找Comment集合
    * @Param: [articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    List<CommentEntity> listComment(Integer articleId);
}
