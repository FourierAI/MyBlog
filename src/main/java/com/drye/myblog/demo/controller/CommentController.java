package com.drye.myblog.demo.controller;

import com.drye.myblog.demo.entity.CommentEntity;
import com.drye.myblog.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: 评论的Controller
 * @author: GeekYe
 * @create: 2018-03-03 16:07
 **/
@Controller
public class CommentController {

    /**
     * @Description: 设值注入
     * @Author: GeekYe
     * @Date: 2018/3/6
     */
    @Autowired
    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
    * @Description: 获取文章对应的评论
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

    /**
    * @Description: 根据文章Id查询管理页的评论表格
    * @Param: []
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/admin/list_comment",method = RequestMethod.GET)
    public String listComment(@RequestParam(value = "articleId") Integer articleId,
                              Model model){
        List<CommentEntity> commentEntities=commentService.listComment(articleId);

        model.addAttribute("commentList",commentEntities);
        model.addAttribute("articleId",articleId);
        return "/templates/comment_manage";
    }

    /**
    * @Description: 删除评论
    * @Param: [articleId, commentId, redirectAttributes]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/admin/delete_comment",method = RequestMethod.GET)
    public String deleteComment(@RequestParam(value = "articleId") Integer articleId,
                                @RequestParam(value = "commentId") Integer commentId,
                                RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("articleId",articleId);
        commentService.deleteComment(commentId);
        return "redirect:/admin/list_comment";
    }
}
