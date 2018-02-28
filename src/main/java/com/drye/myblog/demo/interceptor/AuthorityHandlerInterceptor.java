package com.drye.myblog.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("AlibabaUndefineMagicConstant")
public class AuthorityHandlerInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(AuthorityHandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("拦截器preHandle");
        return true;
    }

    @SuppressWarnings("AlibabaUndefineMagicConstant")
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("拦截器postHandle");
        if(httpServletRequest.getSession().getAttribute("SessionJudge")==null){
            modelAndView.addObject("error","请先登陆您的账号");
            modelAndView.setViewName("/templates/login");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("拦截器afterCompletion");
    }

}
