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
        System.out.println("含铜还是过刘强");
        System.out.println("含铜还是过刘强");
        System.out.println("含铜还是过刘强");
        System.out.println("含铜还是过刘强");
        System.out.println("含铜还是过刘强");
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
