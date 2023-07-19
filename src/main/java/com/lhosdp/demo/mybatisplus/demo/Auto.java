package com.lhosdp.demo.mybatisplus.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.annotation.DbType;
import java.util.ArrayList;
import java.util.List;

public class Auto {

    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/belinkequity?characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
//                "root",
//                "root")
//                .globalConfig(builder -> {
//                    builder.author("guoliuqiang") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D:\\2020ideaCode\\springBootDemo\\src\\main\\java\\com\\lhosdp\\demo\\mybatisplus\\demo"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.lhosdp.demo.mybatisplus") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\2020ideaCode\\springBootDemo\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("wl_bonus_transaction") // 设置需要生成的表名
//                            .addTablePrefix("wl_", "guo_"); // 设置过滤表前缀
//                })
//                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
        // 1、全局配置
//        GlobalConfig globalConfig = new GlobalConfig();//构建全局配置对象
//        String projectPath = System.getProperty("user.dir");// 获取当前用户的目录
//        globalConfig
//                .setOutputDir(projectPath + "/mybatis-plus-01-start/src/main/java")// 输出文件路径
//                .setAuthor("微信搜一搜：贺贺学编程")// 设置作者名字
//                .setOpen(false)// 是否打开资源管理器
//                .setFileOverride(true)// 是否覆盖原来生成的
//                //.setIdType(IdType.AUTO)// 主键策略
//                .setBaseResultMap(true)// 生成resultMap
//                .setBaseColumnList(true)// XML中生成基础列
//                .setServiceName("%sService");// 生成的service接口名字首字母是否为I，这样设置就没有I

        // 2、数据源配置
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();// 创建数据源配置
//        dataSourceConfig
//                .setUrl("jdbc:mysql://localhost:3306/belinkequity?characterEncoding=UTF-8&autoReconnect=true&useSSL=false")
//                .setDriverName("com.mysql.cj.jdbc.Driver")
//                .setUsername("root")
//                .setPassword("root")
//                .setDbType(DbType.MYSQL);

        // 3、包配置
//        PackageConfig packageConfig = new PackageConfig();
//        packageConfig
//                .setParent("com.hzy")
//                .setEntity("entity")
//                .setController("controller")
//                .setService("service")
//                .setMapper("mapper");

        // 4、策略配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig
//                .setCapitalMode(true)// 开启全局大写命名
//                .setInclude("user")// 设置要映射的表
//                .setNaming(NamingStrategy.underline_to_camel)// 下划线到驼峰的命名方式
//                .setColumnNaming(NamingStrategy.underline_to_camel)// 下划线到驼峰的命名方式
//                .setEntityLombokModel(false)// 是否使用lombok
//                .setRestControllerStyle(true)// 是否开启rest风格
//                .setControllerMappingHyphenStyle(true);// localhost:8080/hello_a_2


        // 5、自定义配置（配置输出xml文件到resources下）
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        String templatePath = "/templates/mapper.xml.vm";
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/mybatis-plus-01-start/src/main/resources/mapper/"
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);

        // 6、整合配置
//        AutoGenerator autoGenerator = new AutoGenerator();// 构建代码生自动成器对象
//        autoGenerator
//                .setGlobalConfig(globalConfig)// 将全局配置放到代码生成器对象中
//                .setDataSource(dataSourceConfig)// 将数据源配置放到代码生成器对象中
//                .setPackageInfo(packageConfig)// 将包配置放到代码生成器对象中
//                .setStrategy(strategyConfig)// 将策略配置放到代码生成器对象中
//                .setCfg(cfg)// 将自定义配置放到代码生成器对象中
//                .execute();// 执行！

    }
}
