package com.lhosdp.demo;

import com.lhosdp.demo.mybatisplus.User;
import com.lhosdp.demo.mybatisplus.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUser(){
        List<User> users = this.userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
