package com.drye.myblog.demo.controller;

import com.drye.myblog.demo.aspect.HttpAspect;
import com.drye.myblog.demo.entity.ArticleEntity;
import com.drye.myblog.demo.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/")
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    /**
    * @Description:  模糊查找全站
    * @Param: [field, model]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    @RequestMapping(value = {"findByObscure"},method = RequestMethod.POST)
    public String findByObscure(@RequestParam(value = "field") String field, Model model){

        List<ArticleEntity> articleEntityList=articleService.findByObscure(field);
        model.addAttribute("articleList",articleEntityList);
        return "templates/articles";
    }
    /**
    * @Description: 管理员增加文章
    * @Param: [articleEntity]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    @RequestMapping(value = {"/admin/addArticle"},method = RequestMethod.POST)
    public String addArticle(ArticleEntity articleEntity){
        articleService.addArticle(articleEntity);
        logger.info(articleEntity.toString());
        return "templates/write";
    }
    /**
    * @Description:  管理员删除文章
    * @Param: [articleId, page]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    @RequestMapping(value = "/admin/article/{page}/{articleId}",method = RequestMethod.GET)
    public String deleteArticle(@PathVariable(value = "articleId") Integer articleId,
                                @PathVariable(value = "page") Integer page){

        articleService.deleteArticle(articleId);

        return "redirect:/admin/pagination?page="+page;

    }
}
