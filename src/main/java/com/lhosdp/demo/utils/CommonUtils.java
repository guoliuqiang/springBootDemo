package com.lhosdp.demo.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class CommonUtils {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Long start = simpleDateFormat.parse("1994-12-03 00:00:00").getTime();
//        Long end = simpleDateFormat.parse("2020-11-13 00:00:00").getTime();
//        System.out.println("第一个=="+end);
////        System.out.println("活了" + (end - start) + "毫秒");
//        long totalday = (end - start) / (24 * 60 * 60 * 1000);
//        System.out.println("活了多少天 ："+ totalday);
//        Double d = totalday / 365d;
////        String result = String.format("%.2f");
//
//        System.out.println("约等于：" + d + "年");
//        String activity = "ACTIVITY-6435359605355456";
//        String activityAward = "ACTIVITY-6435359605355456-2";
//        //判断是否有第二个横杠
//        int i = activity.split("-").length;
//        System.out.println(i);
//        int i1 = activityAward.split("-").length;
//        System.out.println(i1);
//        String substring = activityAward.substring(0, activityAward.lastIndexOf("-"));
//        System.out.println(substring);

//        System.out.println(UUID.randomUUID().toString());
//        long time = DateUtils.addDays(new Date(), 10).getTime();
//        System.out.println(time);
//
//        String format = simpleDateFormat.format(new Date(1606730961668L));
//        System.out.println(format);

       // long l = setupAssetExpired(end);
//
//        String format = simpleDateFormat.format(new Date(1612022399 * 1000L));
//        System.out.println(format);




//        long expiredtime = end;
//        String format = simpleDateFormat.format(new Date(expiredtime));
//        String date = format.substring(0, 10)+ " 23:59:59";
//        long time = simpleDateFormat.parse(date).getTime();
//        System.out.println("===="+time);
//        System.out.println(time/1000);
//        long l = time / 1000;
//        String format1 = simpleDateFormat.format(new Date(l * 1000));
//        System.out.println(format1);
//        Integer bonusAmount = 1;
//        Integer exchangeUnit = 300;
//        double cost = (double) bonusAmount / (double)exchangeUnit;
//        long l = new Double(cost * 100).longValue();
//        System.out.println(l);

    }

    /**
     * 处理积分时间
     * @param expiredTime
     * @return
     */
    static public long setupAssetExpired(long expiredTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date(expiredTime));
        String date = format.substring(0, 10)+ " 23:59:59";
        long time = simpleDateFormat.parse(date).getTime();
        return time/1000;
    }



    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        } else {
            DateTime dt = new DateTime(date);
            String dateTemp = dt.toString(pattern);
            return dateTemp;
        }
    }
    public static String arrToStr(String[] arr, String symbol)
    {
        // 实例化StringBuffer
        StringBuffer sb = new StringBuffer();
        // 判断arr是否为有效数组
        if (arr != null && arr.length > 0)
        {
            // 遍历数组
            for (String s : arr)
            {
                // 将字符串追加到StringBuffer中
                sb.append(s);
                // 将字符串追加到StringBuffer中
                sb.append(symbol);
            }
            // 判断字符串长度是否有效
            if (sb.length() > 0)
            {
                // 截取字符
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        }
        // 返回字符串
        return sb.toString();
    }

//    static public long setupAssetExpired(long expiredTime) {
//        if (expiredTime > 0L) {//过期时间按天取整，精确到每天的23：59，单位s（修正时区-8h）
//            expiredTime = (expiredTime / (24 * 3600 * 1000) + 1) * 24 * 3600 - 1 - TimeZone.getDefault().getRawOffset() / 1000;
//        }
//        System.out.println("expiredTime"+ expiredTime);
//
//        return expiredTime;
//    }


}
