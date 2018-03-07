package com.drye.myblog.demo.service.Impl;

import com.drye.myblog.demo.entity.AdminEntity;
import com.drye.myblog.demo.mapper.AdminMapper;
import com.drye.myblog.demo.service.AdminService;
import com.drye.myblog.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * The type Admin service.
 */
@Component
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    /**
     * Gets admin mapper.
     *
     * @return the admin mapper
     */
    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    /**
     * Sets admin mapper.
     *
     * @param adminMapper the admin mapper
     */
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public AdminEntity getAdmin(String name, String password){
        //Md5加密
        name= MD5Util.generateMd5(name);
        password=MD5Util.generateMd5(password);
        return adminMapper.getAdmin(name, password);
    }

}
