package com.lhosdp.demo.controller;

import com.lhosdp.demo.mybatisplus.User;
import com.lhosdp.demo.mybatisplus.UserMapper;
import com.lhosdp.demo.mybatisplus.UserService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guoliuqiang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/testMybatiesUserMapper", method = RequestMethod.GET)
    public List<User> testMybatiesUserMapper(){
        System.out.println(("----- selectAll method test ------"));
        List<User> all = userMapper.findAll();

        Assert.assertEquals(5, all.size());

        all.forEach(System.out::println);
        return all;
    }

    @RequestMapping(value = "/testUserMapper", method = RequestMethod.GET)
    public List<User> testUserMapper(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);

        Assert.assertEquals(5, userList.size());

        userList.forEach(System.out::println);
        return userList;
    }

    /**
     * 使用service查询用户个数
     * @return
     */
    @RequestMapping(value = "/testUserService", method = RequestMethod.GET)
    public Integer testUserService(){
        System.out.println(("----- selectAll method test ------"));
        int count = userService.count();

        System.out.println("数据量为："+count);
        return count;
    }

}
