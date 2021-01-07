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
     * 成本  预算  资金账户
     * 成本户
     * 虚账户
     *
     */
    List<User> findAll();
}
