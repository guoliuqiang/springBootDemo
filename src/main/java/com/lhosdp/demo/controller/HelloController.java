package com.lhosdp.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHello(){
        System.out.println("lkdjflakdflkadfla");
        //
        //
        System.out.println("guoliuqianghaishihantong");
        System.out.println("guoliuqianghaishihantong");
        System.out.println("guoliuqianghaishihantong");
        System.out.println("guoliuqianghaishihantong");
        System.out.println("guoliuqianghaishihantong");
        System.out.println("guoliuqianghaishihantong");
        //
        //
        //
        //
        return "hello hantong";
    }

    @RequestMapping("/getTime")
    public String getTime(){
        return System.currentTimeMillis() + "";
    }
}
