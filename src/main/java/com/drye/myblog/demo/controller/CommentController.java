package com.drye.myblog.demo.controller;

import com.drye.myblog.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: MyBlogVersion1
 * @description: 评论的Controller
 * @author: GeekYe
 * @create: 2018-03-03 16:07
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    /**
    * @Description:
    * @Param: [articleId, commentName, commentEmail, commentContent, commentTime]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    @RequestMapping(value = "/article/{article.articleId}/comment",method = RequestMethod.POST)
    public String saveComment(@PathVariable(value = "article.articleId") Integer articleId,
                              @RequestParam(value = "commentName") String commentName,
                              @RequestParam(value = "commentEmail") String commentEmail,
                              @RequestParam(value = "commentContent") String commentContent){

        commentService.saveComment(commentName,commentEmail,commentContent,articleId);

        return "redirect:/article?articleId="+articleId;
    }

}
