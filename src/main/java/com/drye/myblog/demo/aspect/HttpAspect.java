package com.drye.myblog.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 切点*/
    @Pointcut("execution(public * com.drye.myblog.demo.controller.*.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //url
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=attributes.getRequest();
        logger.info("url={}",httpServletRequest.getRequestURL());
        //method
        logger.info("method={}",httpServletRequest.getMethod());
        //ip
        logger.info("ip={}",httpServletRequest.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void daAfter(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String date=simpleDateFormat.format(new Date());
        logger.info("-------------------------------------------------结束时间"+date);
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void adAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
