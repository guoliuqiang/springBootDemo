package com.lhosdp.demo.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author guoliuqaing
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
