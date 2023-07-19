package com.lhosdp.demo.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author guoliuqaing
 */
public interface UserMapper extends BaseMapper<User> {

    int insertUser(@Param("user") User user);

    User selectUser(@Param("id") String id);



}


