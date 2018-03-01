package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    /**
    * @Description:  显示在主页
    * @Param: []
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findHome();
    /**
    * @Description:  按条件查找文章
    * @Param: [category]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findBycategory(String category);
    /**
    * @Description:  pagination分页效果
    * @Param: [category]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    Integer pagination(String category);
    /**
    * @Description:  按照<li><a></a></li>标签传来的值，确定将哪部分内容呈现给用户
    * @Param: [category, page]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findByPagination(String category,Integer page);
    /**
    * @Description:  模糊查找
    * @Param: [field]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findByObscure(String field);
    /**
    * @Description:  在管理界面显示文章列表
    * @Param: []
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findAtAdminHome(Integer page);
    /**
    * @Description: 管理分页效果
    * @Param: [category]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/3/1
    */
    Integer adminPagination(String category);
    /**
    * @Description:  增加文章
    * @Param: [articleEntity]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    void addArticle(ArticleEntity articleEntity);
    /**
    * @Description:  根据ID删除文章
    * @Param: [articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    void deleteArticle(Integer articleId);
    /**
    * @Description: 按照时间排序显示
    * @Param: [method]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/3/1
    */
    List<ArticleEntity> findByTime(String method, Integer page, String category);
}
