package com.drye.myblog.demo.controller;


import com.drye.myblog.demo.entity.ArticleEntity;
import com.drye.myblog.demo.service.ArticleService;
import com.drye.myblog.demo.service.CommentService;
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

/**
* @Description: ArticleController
* @Author: GeekYe
* @Date: 2018/3/6
*/
@RequestMapping("/")
@Controller
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    /**
     * @Description: 设值注入
     * @Author: GeekYe
     * @Date: 2018/3/6
     */
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
    * @Description:  模糊查找全站
    * @Param: [field, model]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    @RequestMapping(value = {"findByObscure"}, method = RequestMethod.POST)
    public String findByObscure(@RequestParam(value = "field") String field, Model model){

        List<ArticleEntity> articleEntityList = articleService.listArticlesByObscure(field);

        model.addAttribute("articleList", articleEntityList);

        return "templates/articles";
    }

    /**
    * @Description: 管理员增加文章
    * @Param: [articleEntity]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    @RequestMapping(value = {"/admin/addArticle"}, method = RequestMethod.POST)
    public String addArticle(ArticleEntity articleEntity){

        articleService.saveArticle(articleEntity);

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
    @RequestMapping(value = "/admin/article", method = RequestMethod.GET)
    public String deleteArticle(@RequestParam(value = "articleId") Integer articleId,
                                @RequestParam(value = "page") Integer page,
                                @RequestParam(value = "category", defaultValue = "default") String category,
                                @RequestParam(value = "method", defaultValue = "asc") String method,
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
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String getArticleById(@RequestParam(value = "articleId") Integer articleId,
                                 Model model){

        model.addAttribute("article", articleService.getArticleById(articleId));
        model.addAttribute("commentList", commentService.listComment(articleId));

        return "/templates/article";
    }

    /**
    * @Description:  根据articleId修改文章
    * @Param: [articleId, model]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/admin/update/{articleId}", method = RequestMethod.GET)
    public String Update(@PathVariable(value = "articleId") Integer articleId,
                         Model model){

        model.addAttribute("article", articleService.getArticleByIdNotMD(articleId));

        return "templates/update_article";
    }

    /**
    * @Description:
    * @Param: [articleCategory, articleTitle, articleContent, articleId]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/admin/updateArticle", method = RequestMethod.POST)
    public String updateArticle(@RequestParam(value = "articleCategory") String articleCategory,
                                @RequestParam(value = "articleTitle") String articleTitle,
                                @RequestParam(value = "articleContent") String articleContent,
                                @RequestParam(value = "articleId") Integer articleId){

        articleService.updateArticleById(articleId, articleCategory, articleTitle, articleContent);

        return "redirect:/admin/pagination";
    }

    /**
    * @Description: 模糊查找文章
    * @Param: [field, model]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/admin/articleByObscure", method = RequestMethod.POST)
    public String getArticleByObscure(@RequestParam(value = "field") String field,
                                      Model model){

        List<ArticleEntity> articleEntityList = articleService.listArticlesByObscure(field);

        model.addAttribute("articleList", articleEntityList);

        return "templates/article_obscure";
    }

    /**
    * @Description: 获取文章的上一页与下一页内容
    * @Param: [direction, articleId]
    * @return: java.lang.String
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @RequestMapping(value = "/article/direction/{direction}/{articleId}", method = RequestMethod.GET)
    public String getArticleByDirection(@PathVariable(value = "direction") String direction,
                                        @PathVariable(value = "articleId") Integer articleId){

        return "redirect:/article?articleId="+articleService.getArticleByDirection(direction, articleId);
    }
}
