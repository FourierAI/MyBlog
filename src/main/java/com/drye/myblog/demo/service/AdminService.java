package com.drye.myblog.demo.service;

import com.drye.myblog.demo.entity.AdminEntity;

/**
 * @author GeekYe
 * @Description: 管理员service
 * @Date 2018 /03/07
 */
public interface AdminService {


    /**
     * Gets admin.
     *
     * @param name     the name
     * @param password the password
     * @return the admin
     */
    AdminEntity getAdmin(String name, String password);
}
