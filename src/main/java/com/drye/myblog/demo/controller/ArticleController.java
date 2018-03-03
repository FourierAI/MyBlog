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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @RequestMapping(value = "/admin/article",method = RequestMethod.GET)
    public String deleteArticle(@RequestParam(value = "articleId") Integer articleId,
                                @RequestParam(value = "page") Integer page,
                                @RequestParam(value = "category",defaultValue = "default") String category,
                                @RequestParam(value = "method",defaultValue = "asc") String method,
                                RedirectAttributes redirectAttributes){
        articleService.deleteArticle(articleId);
        redirectAttributes.addAttribute("page", page);
        redirectAttributes.addAttribute("category", category);
        redirectAttributes.addAttribute("method", method);
        return "/admin/pagination";
    }
    /**
    * @Description: 通过learn more传来的articleId获取文章详细信息
    * @Param: [articleId, model]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/3
    */
    @RequestMapping(value = "/article/{articleId}",method = RequestMethod.GET)
    public String getArticleById(@PathVariable(value = "articleId") Integer articleId,
                                 Model model){
        model.addAttribute("article",articleService.getArticleById(articleId));
        return "/templates/article";
    }
}
