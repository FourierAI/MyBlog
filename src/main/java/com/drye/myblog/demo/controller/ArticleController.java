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
    @RequestMapping(value = {"findByObscure"},method = RequestMethod.POST)
    public String findByObscure(@RequestParam(value = "field") String field, Model model){

        List<ArticleEntity> articleEntityList=articleService.findByObscure(field);
        model.addAttribute("articleList",articleEntityList);
        return "templates/articles";
    }

    @RequestMapping(value = {"/addArticle"},method = RequestMethod.POST)
    public String addArticle(ArticleEntity articleEntity){
        articleService.addArticle(articleEntity);
        logger.info(articleEntity.toString());
        return "templates/write";
    }
}
