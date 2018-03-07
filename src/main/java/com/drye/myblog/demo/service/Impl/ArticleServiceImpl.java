package com.drye.myblog.demo.service.Impl;

import com.drye.myblog.demo.entity.ArticleEntity;
import com.drye.myblog.demo.mapper.ArticleMapper;
import com.drye.myblog.demo.service.ArticleService;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Article service.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * Sets article mapper.
     *
     * @param articleMapper the article mapper
     */
    @Autowired
    private ArticleMapper articleMapper;

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<ArticleEntity> listArticlesAtHome() {
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesAtHome();
        for (ArticleEntity art:articleEntityList
             ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public List<ArticleEntity> listArticlesByCategory(String category) {
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesByCategory(category);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public Integer countPaginationByCategory(String category) {
        Integer num=articleMapper.countPaginationByCategory(category);
        Integer MOD = num % 5;
        Integer result = num / 5;

        return MOD == 0 ? result : result + 1;

    }

    @Override
    public List<ArticleEntity> listArticlesByPagination(String category, Integer page) {
        List<ArticleEntity> articleEntityList=articleMapper.listArticlesByPagination(category,page);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;

    }

    @Override
    public List<ArticleEntity> listArticlesByObscure(String field) {
        List<ArticleEntity> articleEntityList = articleMapper.listArticlesByObscure(field);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public List<ArticleEntity> listArticlesAtAdminHome(Integer page) {
        page=page*20;
        return articleMapper.listArticlesAtAdminHome(page);
    }

    @Override
    public Integer countAdminPaginationByCategory(String category) {
        Integer paginationNum=articleMapper.countAdminPaginationByCategory(category);
        return paginationNum%20==0 ? paginationNum/20 : paginationNum/20+1;
    }

    @Override
    public void saveArticle(ArticleEntity articleEntity) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleEntity.setArticleTime(df.format(date));
        articleMapper.saveArticle(articleEntity.getArticleCategory(),articleEntity.getArticleTitle(),articleEntity.getArticleContent(),articleEntity.getArticleTime());
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
    }

    @Override
    public List<ArticleEntity> listArticlesAtAdminByTime(String method, Integer page, String category) {
        page=page*20;
        return articleMapper.listArticlesAtAdminByTime( method , page , category );
    }

    @Override
    public ArticleEntity getArticleById(Integer articleId) {
        ArticleEntity articleEntity=articleMapper.getArticleById(articleId);
        articleEntity.setArticleContent( MDTool.markdown2Html( articleEntity.getArticleContent() ) );
        return articleEntity;
    }

    @Override
    public ArticleEntity getArticleByIdNotMD(Integer articleId) {
        return articleMapper.getArticleById(articleId);
    }

    @Override
    public void updateArticleById(Integer articleId, String articleCategory, String articleTitle, String articleContent) {
        articleMapper.updateArticleById(articleId,articleCategory,articleTitle,articleContent);
    }
    /**
    * @Description: String类中 == equals 的区别
    * @Param: [direction, articleId]
    * @return: java.lang.Integer
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @Override
    public Integer getArticleByDirection(String direction, Integer articleId) {
        final String DIRECTION_PREVIOUS="previous";
        final String DIRECTION_NEXT="next";
        Integer offest=articleMapper.countBeforeRecord(articleId);
        if(direction.equals(DIRECTION_PREVIOUS)){
            return articleMapper.getArticleIdByLimit(offest-1);
        }
        if(direction.equals(DIRECTION_NEXT)){
            return articleMapper.getArticleIdByLimit(offest+1);
        }
        return articleId;
    }

}
