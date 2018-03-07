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
 * The type Comment mapper test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * Sets comment mapper.
     *
     * @param commentMapper the comment mapper
     */
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    /**
     * Save comment test.
     */
    @Test
    public void saveCommentTest(){
        commentMapper.saveComment("测试","939647181@qq.com","测试","2018：12：20",90);
    }

    /**
     * List comment test.
     */
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
