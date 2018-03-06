package com.drye.myblog.demo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class AuthorityInterceptor extends WebMvcConfigurerAdapter {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorityHandlerInterceptor())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/admin/**");
                //排除不需要验证登录用户操作权限的请求

    }
}
