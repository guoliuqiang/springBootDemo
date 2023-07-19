package com.lhosdp.demo.kafkademo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Constants {
    public static final String transactionDatabaseUrl = "jdbc:mysql://192.168.201.44:3306/%s?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
    public static final String transactionDatabaseDriver = "com.mysql.cj.jdbc.Driver";
    public static final String transactionDatabaseUser = "dev_ibbp";;
    public static final String transactionDatabasePassword = "1q#EeujF";


    public static final String databaseUrl = "jdbc:mysql://101.251.195.186:3306/%s?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
    public static final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    public static final String databaseUser = "dev_ibbp";;
    public static final String databasePassword = "1q#EeujF";

    public static final String redisServer = "192.168.5.6";
//    public static final String redisServer = "localhost";
    public static final int redisPort = 6379;

    public static final String kafkaServer = "101.251.195.186:9092";
    public static final String strategyTopic = "TIP_BELINK";
    public static final String userLogTopic = "BELINK_WEPUSH";
    public static final String userBusinessLogTopic = "BELINK_BUSINESS";
    public static final String resultTopic = "BELINK_SOURCE_EVENT";

    public static final int bloomCapacity = 1 << 29;

    public static final SimpleDateFormat timePattern = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatTimeForTimestamp(long timestamp) {
        return timePattern.format(new Date(timestamp));
    }

    public static String today() {
        Date date = new Date();
        return timePattern.format(date);
    }

    public static String yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return timePattern.format(cal.getTime());
    }

    public static String transactionDatabase() {
        return String.format(transactionDatabaseUrl, "dev_ibbp_equity");
    }

    public static String strategyDatabase() {
        return String.format(databaseUrl, "dmp_strategy");
    }

    public static String resultDatabase() {
        return String.format(databaseUrl, "dmp_strategy");
    }


}
