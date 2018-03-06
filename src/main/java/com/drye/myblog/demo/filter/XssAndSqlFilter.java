package com.drye.myblog.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: MyBlogVersion1
 * @description: xss过滤器
 * @author: GeekYe
 * @create: 2018-03-06 18:23
 **/
public class XssAndSqlFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了destory方法执行了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);
        System.out.println(xssRequest.toString());
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("init方法init方法init方法init方法init方法init方法init方法init方法init方法init方法");
    }

}
