package com.drye.myblog.demo.mapper;

import com.drye.myblog.demo.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {

    /**校对账号密码*/
    AdminEntity selectAdmin(@Param(value = "name") String name,@Param(value = "password") String password);
    /**增加Admin账号密码*/
    void addAdmin(@Param(value = "name") String name, @Param(value = "password") String password);

}
