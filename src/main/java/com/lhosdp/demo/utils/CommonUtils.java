package com.lhosdp.demo.utils;

import java.sql.Time;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtils {

    public static void main(String[] args) throws ParseException {
        System.out.println(UUID.randomUUID().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date parse = simpleDateFormat.parse("2020-12-30 00:00:00");

        //System.out.println(parse.getTime());

         Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
        //毫秒值
        Long timems = date.getTime();
        System.out.println(timems);
        Long time = timems / 1000;
        Date date1 = new Date(time * 1000);
        String format = simpleDateFormat.format(date1);
        System.out.println(format);

//1588935169
        System.out.println("====");
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(simpleDateFormat.format(new Date(1591977599*1000L)));



    }

    static public long setupAssetExpired(long expiredTime) {
        if (expiredTime > 0L) {//过期时间按天取整，精确到每天的23：59，单位s（修正时区-8h）
            expiredTime = (expiredTime / (24 * 3600 * 1000) + 1) * 24 * 3600 - 1 - TimeZone.getDefault().getRawOffset() / 1000;
        }
        System.out.println("expiredTime"+ expiredTime);
        return expiredTime;
    }
}
