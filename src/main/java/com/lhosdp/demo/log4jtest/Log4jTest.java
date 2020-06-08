package com.lhosdp.demo.log4jtest;




import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @author guoliuqaing
 */
public class Log4jTest {

    @Test
    public void testQuick() throws Exception{
        //初始化配置信息，在入门案例中暂不使用配置信息
        BasicConfigurator.configure();
        //获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);
//
        //日志记录输出
        //日志级别
        logger.info("shuchu");



    }

}
