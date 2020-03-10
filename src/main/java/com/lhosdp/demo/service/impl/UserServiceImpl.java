package com.lhosdp.demo.service.impl;

import com.lhosdp.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(String userId) {
        return "guoliuqiang user name";
    }
}
