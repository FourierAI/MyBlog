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

    }

    /**
    * @Description: 过滤request参数
    * @Param: [request, response, chain]
    * @return: void
    * @Author: GeekYe
    * @Date: 2018/3/6
    */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
