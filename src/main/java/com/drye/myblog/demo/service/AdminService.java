package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.AdminEntity;

public interface AdminService {
    /**
    * @Description:
    * @Param: [name, password]
    * @return: com.drye.myblog.demo.entity.AdminEntity
    * @Author: GeekYe
    * @Date: 2018/2/13
    */
    AdminEntity selectAdmin(String name , String password);
}
