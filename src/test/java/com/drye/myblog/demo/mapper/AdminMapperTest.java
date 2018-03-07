package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.AdminEntity;
import com.drye.myblog.demo.util.MD5Util;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Admin mapper test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

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

    /**
     * Get admin test.
     */
    @Test
    public void getAdminTest(){

        AdminEntity adminEntity1;

        if( (adminEntity1=adminMapper.getAdmin("yezhipeng","123") )!=null)
            System.out.println(adminEntity1.toString());
        else System.out.println("error");

    }

    /**
     * Save admin test.
     */
    @Test
    public void saveAdminTest(){

        adminMapper.saveAdmin(MD5Util.generateMd5("939647181@qq.com"),MD5Util.generateMd5("123"));

    }
}
