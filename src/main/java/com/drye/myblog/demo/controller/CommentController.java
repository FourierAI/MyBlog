package com.drye.myblog.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: MyBlogVersion1
 * @description: 评论的Controller
 * @author: GeekYe
 * @create: 2018-03-03 16:07
 **/
@Controller
public class CommentController {
    @RequestMapping(value = "/article/{article.articleId}/comment",method = RequestMethod.POST)
    public String saveComment(@PathVariable(value = "article.articleId") Integer articleId,
                              Model model){

        return "redirect:/article/"+articleId;
    }
}
