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
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 将markdown转换成html,显示在主页*/
    @Override
    public List<ArticleEntity> findHome() {
        List<ArticleEntity> articleEntityList=articleMapper.findHome();
        for (ArticleEntity art:articleEntityList
             ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public List<ArticleEntity> findBycategory(String category) {
        List<ArticleEntity> articleEntityList=articleMapper.findBycategory(category);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public Integer pagination(String category) {
        Integer num=articleMapper.articlePagination(category);
        Integer MOD = num % 5;
        Integer result = num / 5;

        return MOD == 0 ? result : result + 1;

    }

    @Override
    public List<ArticleEntity> findByPagination(String category, Integer page) {
        List<ArticleEntity> articleEntityList=articleMapper.findByPagination(category,page);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;

    }

    @Override
    public List<ArticleEntity> findByObscure(String field) {
        List<ArticleEntity> articleEntityList = articleMapper.findByObscure(field);
        for (ArticleEntity art:articleEntityList
                ) {
            String str=art.getArticleContent();
            art.setArticleContent(MDTool.markdown2Html(str));
        }
        return articleEntityList;
    }

    @Override
    public List<ArticleEntity> findAtAdminHome(Integer page) {
        page=page*20;
        return articleMapper.findAtAdminHome(page);
    }

    @Override
    public Integer adminPagination() {
        Integer paginationNum=articleMapper.adminPagination();
        return paginationNum%20==0 ? paginationNum/20 : paginationNum/20+1;
    }

    @Override
    public void addArticle(ArticleEntity articleEntity) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleEntity.setArticleTime(df.format(date));
        articleMapper.addArticle(articleEntity.getArticleCategory(),articleEntity.getArticleTitle(),articleEntity.getArticleContent(),articleEntity.getArticleTime());
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
    }

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }
}
