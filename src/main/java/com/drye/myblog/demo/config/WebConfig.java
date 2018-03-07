package com.drye.myblog.demo.config;

import com.drye.myblog.demo.filter.XssAndSqlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyBlogVersion1
 * @description: web配置
 * @author: GeekYe
 * @create: 2018-03-06 18:21
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FilterRegistrationBean getDemoFilter(){
        XssAndSqlFilter xssAndSqlFilter = new XssAndSqlFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(xssAndSqlFilter);
        List<String> urlPatterns = new ArrayList();
        //拦截路径，可以添加多个
        urlPatterns.add("/article/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
