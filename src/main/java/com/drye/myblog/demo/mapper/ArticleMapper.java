package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {

    /**
    * @Description:  按照更新时间，显示主页的文章
    * @Param: []
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    List<ArticleEntity> findHome();

    /**
    * @Description:  按种类查询，显示在各个分页上
    * @Param: [category]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    List<ArticleEntity> findByCategory(@Param(value = "category") String category);

    /**
    * @Description:  增加文章
    * @Param: [category, title, content, time]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    void addArticle(@Param(value = "category") String category,@Param(value = "title") String title,@Param(value = "content") String content,@Param(value = "time") String time);

    /**
    * @Description:  分页效果
    * @Param: [category]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    Integer articlePagination(@Param(value = "category") String category);
    /**
    * @Description:  按索引分页查找文章
    * @Param: [category, page]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    List<ArticleEntity> findByPagination(@Param(value = "category") String category,@Param(value = "page") Integer page);

    /**
    * @Description: 主页模糊查找
    * @Param: [field, page]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    List<ArticleEntity> findByObscure(@Param(value = "field") String field);
    /**
    * @Description:  根据page参数，分页显示文章列表信息
    * @Param: [page]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/2/15
    */
    List<ArticleEntity> findAtAdminHome(@Param(value = "page") Integer page);
    /**
    * @Description:  分页效果
    * @Param: []
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/2/16
    */
    Integer adminPagination(@Param(value = "category") String category);
    /**
    * @Description:  根据前端传过来的articleId来删除文章
    * @Param: [articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/2/28
    */
    void deleteArticle(@Param(value = "articleId") Integer articleId);
    /**
    * @Description:  通过时间排序
    * @Param: [method, page]
    * @return: java.util.List<com.drye.myblog.demo.entity.ArticleEntity>
    * @Author: GeekYe
    * @Date: 2018/3/1
    */
    List<ArticleEntity> findByTime(@Param(value = "method") String method,
                                   @Param(value = "page") Integer page,
                                   @Param(value = "articleCategory") String articleCategory);
    /**
    * @Description:  通过Id获取文章详情
    * @Param: [articleId]
    * @return: com.drye.myblog.demo.entity.ArticleEntity
    * @Author: GeekYe
    * @Date: 2018/3/3
    */
    ArticleEntity getArticleById(@Param(value = "articleId") Integer articleId);
    /**
    * @Description:  修改文章内容
    * @Param: [articleId]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/3/4
    */
    void updateArticle(@Param(value = "articleId") Integer articleId,
                       @Param(value = "articleCategory") String articleCategory,
                       @Param(value = "articleTitle") String articleTitle,
                       @Param(value = "articleContent") String articleContent);
    /**
    * @Description:  通过articleId查询之前有几条记录，来确定偏移量
    * @Param: [articleId]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/3/5
    */
    Integer countBeforeRecord(@Param(value = "articleId") Integer articleId);
    /**
    * @Description:  通过偏移量查询articleId
    * @Param: [offest]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/3/5
    */
    Integer getArticleIdByLimit(@Param(value = "offest") Integer offest);
}
