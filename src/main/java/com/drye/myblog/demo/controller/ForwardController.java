package com.drye.myblog.demo.controller;

import com.drye.myblog.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class ForwardController {
    @Autowired
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     *  主页跳转,从后端取最新几期更新的文章
     */
    @RequestMapping(value = {"index",""},method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("articleList",articleService.findHome());
        return "templates/index";
    }
    /**
     *  管理员登陆跳转
     */
    @RequestMapping(value = {"login"},method = RequestMethod.GET)
    public String login(){
        return "templates/login";
    }
    /**
     *  文章页面跳转
     */
    @RequestMapping(value = {"articles"},method = RequestMethod.GET)
    public String articles(@RequestParam("category") String category,@RequestParam("page") Integer page, Model model){
        if(page <=0 ) {
            page = 1;
        }
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        model.addAttribute("pagination", articleService.pagination(category));
        model.addAttribute("articleList",articleService.findByPagination(category, (page-1)*5));
        return "templates/articles";
    }
    /**
    * @Description: 跳转到文章书写页面
    * @Param: []
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/27
    */
    @RequestMapping(value = "write",method = RequestMethod.GET)
    public String write(){
        return "templates/write";
    }
}
