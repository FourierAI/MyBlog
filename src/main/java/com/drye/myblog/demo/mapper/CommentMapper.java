package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: 评论系统
 * @author: GeekYe
 * @create: 2018-03-03 16:22
 **/
@Mapper
@Component
public interface CommentMapper {
    /**
    * @Description:  通过articleId关联保存comment
    * @Param: [commentName, commentEmail, commentContent, commentTime, articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    void saveComment(@Param(value = "commentName") String commentName,
                     @Param(value = "commentEmail") String commentEmail,
                     @Param(value = "commentContent") String commentContent,
                     @Param(value = "commentTime") String commentTime,
                     @Param(value = "articleId") Integer articleId);
    /**
    * @Description:  通过articleId查询匹配的comment记录
    * @Param: [articleId]
    * @return: java.util.List<com.drye.myblog.demo.entity.CommentEntity>
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    List<CommentEntity> listComment(@Param(value = "articleId") Integer articleId);
}
