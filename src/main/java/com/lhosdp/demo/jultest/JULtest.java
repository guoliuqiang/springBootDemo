package com.lhosdp.demo.jultest;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

public class JULtest {



    @Test
    public void testQuick(){
        //创建日志记录器对象
        Logger logger = Logger.getLogger("com.lhosdp.demo.jultest.JULtest");
        //日志记录输出
        logger.info("logger 记录");

        logger.log(Level.INFO, "info 日志");

        //通过占位符，输入变量
        String name = "guoliuqiang";
        Integer age = 27;
        logger.log(Level.INFO, "用户信息: {0} {1}", new Object[]{name, age});

    }

    /**
     * 测试各种日志级别信息
     */
    @Test
    public void testLevel(){
        //创建日志记录器对象
        Logger logger = Logger.getLogger("com.lhosdp.demo.jultest.JULtest");
        //输出
        //最高级别，出现重大问题，造成程序的终止使用servere
        logger.severe("servere");
        //警告信息，记录发生的问题，但是这些问题不会造成程序的终止
        logger.warning("warning");
        //jul默认的日志级别是INFO  消息级别，输出一些数据库链接信息之类的
        logger.info("info");
        //配置信息，加载配置信息，读取配置信息
        logger.config("config");
        //下边三个都是debug级别的日志，只是颗粒度不同
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
        //Level.ALL  //打开日志  所有级别都开启
//        Level.OFF //关闭日志  所有级别都关闭

    }

    /**
     * 自定义配置日志输出信息
     */
    @Test
    public void testLogConfig() throws IOException {
        //创建日志记录器对象
        Logger logger = Logger.getLogger("com.lhosdp.demo.jultest.JULtest");
        //关闭系统默认配置
        logger.setUseParentHandlers(false);
        /*
        自定义配置日志级别
         */
        //创建ConsolHandler控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        //一个logger可以指定多个handler
        logger.addHandler(consoleHandler);

        //配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        /*
        场景FileHandler 文件输出
         */
        FileHandler fileHandler = new FileHandler("D:\\2020ideaCode\\springBootDemo\\logs\\jul.log");

        //进行关联
        fileHandler.setFormatter(simpleFormatter);
        //一个logger可以指定多个handler
        logger.addHandler(fileHandler);



        logger.severe("servere");
        //警告信息，记录发生的问题，但是这些问题不会造成程序的终止
        logger.warning("warning");
        //jul默认的日志级别是INFO  消息级别，输出一些数据库链接信息之类的
        logger.info("info");
        //配置信息，加载配置信息，读取配置信息
        logger.config("config");
        //下边三个都是debug级别的日志，只是颗粒度不同
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }

    /**
     * 测试logger的父子及关系
     * 根据包名来创建父子级对象
     * 顶级对象为java.util.logging.LogManager$RootLogger
     */
    @Test
    public void testLoggerParent(){
        //创建日志记录器对象
        Logger logger = Logger.getLogger("com.lhosdp.demo.jultest.JULtest");
        Logger logger1 = Logger.getLogger("com.lhosdp.demo.jultest");
        Logger com = Logger.getLogger("com");
        System.out.println(logger.getParent());
        System.out.println(logger1);
        System.out.println(com.getParent());



    }
}
