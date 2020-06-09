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
        //严重错误，一般会造成系统崩溃并终止运行
        logger.fatal("fatal shuchu");
        //错误，不会影响系统运行
        logger.error("error shuchu");
        //警告，可能会发生问题
        logger.warn("warn shuchu");
        //运行信息，数据链接，网络链接，IO操作等
        logger.info("info shuchu");
        //调试信息，一般在开发中使用，记录程序变量参数等信息
        logger.debug("debug shuchu");
        //追踪信息，记录程序所有的流程信息  log4j默认级别是debug,最后trace这个级别的数据不会输出
        logger.trace("trace shuchu");



    }

}
