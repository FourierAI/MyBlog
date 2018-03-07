package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GeekYe
 * @Description: AdminMapper
 * @Date 2018 /03/07
 */
@Mapper
@Component
public interface AdminMapper {

    /**
     * Gets admin.
     *
     * @param name     the name
     * @param password the password
     * @return the admin
     */
    AdminEntity getAdmin(@Param(value = "name") String name, @Param(value = "password") String password);

    /**
     * Save admin.
     *
     * @param name     the name
     * @param password the password
     */
    void saveAdmin(@Param(value = "name") String name, @Param(value = "password") String password);

}
