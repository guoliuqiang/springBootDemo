package com.lhosdp.demo.utils;

import sun.plugin.com.Utils;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class CommonUtils {

    public static void main(String[] args) throws ParseException {
//        System.out.println(UUID.randomUUID().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = simpleDateFormat.parse("2020-12-30 00:00:00");
//
//        System.out.println(parse.getTime());
//        long l = setupAssetExpired(new Date().getTime());
//        System.out.println(l);

        Long time = 1584806399 * 1000L;
        Date date = new Date(time);
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    static public long setupAssetExpired(long expiredTime) {
        if (expiredTime > 0L) {//过期时间按天取整，精确到每天的23：59，单位s（修正时区-8h）
            expiredTime = (expiredTime / (24 * 3600 * 1000) + 1) * 24 * 3600 - 1 - TimeZone.getDefault().getRawOffset() / 1000;
        }
        return expiredTime;
    }
}
