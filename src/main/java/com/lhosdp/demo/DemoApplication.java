package com.lhosdp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guoliuqaing
 */
@SpringBootApplication
//@MapperScan('com.lhosdp.demo.mybatisplus')
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
