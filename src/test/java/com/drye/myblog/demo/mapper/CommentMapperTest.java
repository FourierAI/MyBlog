package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.CommentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: comment的Mapper测试
 * @author: GeekYe
 * @create: 2018-03-04 14:36
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
    @Test
    public void saveCommentTest(){
        commentMapper.saveComment("测试","939647181@qq.com","测试","2018：12：20",90);
    }
    @Test
    public void listCommentTest(){
        List<CommentEntity> commentEntities=commentMapper.listComment(1);
        for (CommentEntity c:commentEntities
             ) {
            System.out.println(c.getArticleEntity().getArticleTitle());
            System.out.println(c.toString());
        }
    }
}
