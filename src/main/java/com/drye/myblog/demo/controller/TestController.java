package com.drye.myblog.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: MyBlogVersion1
 * @description: 测试
 * @author: GeekYe
 * @create: 2018-03-01 21:00
 **/
@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public String test(@RequestParam(value = "test") String str){
        return str;
    }

    @RequestMapping(value = "/redirect")
    public String redirect(){
        String str="中文";
        return "redirect:/test?"+str;
    }
}
