package com.lhosdp.demo.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.HashUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhosdp.demo.domain.DistributionCommandDto;
import com.lhosdp.demo.enums.PeriodType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class CommonUtils {

    public static void main(String[] args) throws JsonProcessingException, ParseException {
//        String traceId = null;
//        if(StringUtils.isEmpty(traceId)){
//            System.out.println("执行");
//        }else{
//            System.out.println("不执行");
//        }
//        System.out.println(PeriodType.MOUTH);
//        System.out.println(PeriodType.MOUTH.getName());
//        System.out.println(PeriodType.MOUTH.name());
//        List<String> sss = new ArrayList<>();
//        sss.add("60b040b60eafaac54c6f5483");
//        sss.add("60b040b90eafaac54c6f5484");
//         ObjectMapper objectMapper = new ObjectMapper();
//
////        System.out.println(s);
//                List<DistributionCommandDto> dtos = new ArrayList<>();
//        DistributionCommandDto to = new DistributionCommandDto();
//
//        to.setStrategyId("852fasdfe4f8e48f4e84sf6e555234");
//        to.setForABTest(true);
//        to.setDiversionRadio(23);
//        to.setCustomerGroup("WHITELIST");
//        to.setCustomerGroupType("654988464");
//        to.setCityAndBranch("");
//        to.setIsRepeated(true);
//        to.setStartTime(DateUtils.addDays(new Date(), 10));
//        to.setEndTime(DateUtils.addDays(new Date(), 20));
//        to.setPeriod("WEEK");
//        to.setPeriodDay(5);
//        to.setChannel("AD");
//        to.setField("1-1-1");
//        to.setResourceType("MENU");
//        to.setResourceId("1234568546");
//        DistributionCommandDto to1 = new DistributionCommandDto();
//        to1.setStrategyId("852fasdfe4f8e48f4e84sf6e555234999");
//        to1.setForABTest(true);
//        to1.setDiversionRadio(23);
//        to1.setCustomerGroup("WHITELIST");
//        to1.setCustomerGroupType("654988464");
//        to1.setCityAndBranch("");
//        to1.setIsRepeated(true);
//        to1.setStartTime(DateUtils.addDays(new Date(), 10));
//        to1.setEndTime(DateUtils.addDays(new Date(), 20));
//        to1.setPeriod("WEEK");
//        to1.setPeriodDay(5);
//        to1.setChannel("AD");
//        to1.setField("1-1-1");
//        to1.setResourceType("MENU");
//        to1.setResourceId("1234568546");
//        dtos.add(to);
//        dtos.add(to1);
//        String s = objectMapper.writeValueAsString(dtos);
//        System.out.println(s);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
//        long time = date.getTime();
//        long miao = time/1000L;
//        long fen = miao/10L;
//        long shi = fen/10L;
//        System.out.println(miao);
//        String str = "customerUserNum=3,gmtModified=2021-05-26 16:07:54,groupName=私人定制,id=1397464496800403456,importType=01,state=00";
//        int i = HashUtil.oneByOneHash(str);
//        int i1 = i % 100;
//        System.out.println(i1);
//        int i = HashUtil.oneByOneHash("CustomerUserList(id=21, customerGroupId=1397464496800403456, userName=郭果果, userId=200000001181, mobile=13311201459, sex=男, age=27, userType=游客, label=中收入人群, state=启用)");
//        System.out.println(i);

//        String nowday = DateUtil.formatDate(new Date());
//        System.out.println(nowday);

//        List<DistributionCommandDto> dtos = new ArrayList<>();
//        DistributionCommandDto to = new DistributionCommandDto();
//        to.setStrategyId("cba6837a-2922-4296-95e4-27309a6060b53");
//        to.setForABTest(true);
//        to.setDiversionRadio(23);
//        to.setCustomerGroup("1397464496800403456");
//        to.setCustomerGroupType("WHITELIST");
//        to.setCityAndBranch("");
//        to.setIsRepeated(true);
//        to.setStartTime(DateUtils.addDays(new Date(), 10));
//        to.setEndTime(DateUtils.addDays(new Date(), 20));
//        to.setPeriod("WEEK");
//        to.setPeriodDay(5);
//        to.setChannel("AD");
//        to.setField("1-1-1");
//        to.setResourceType("MENU");
//        to.setResourceId("1234568546");
//        dtos.add(to);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(dtos);
//        System.out.println(s);
//
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = simpleDateFormat.parse("2021-06-06 01:01:01");
//        Calendar c=Calendar.getInstance();
//        c.setTime(parse);
//        int weekday= c.get(Calendar.DAY_OF_WEEK);
//        System.out.println(weekday - 1);
//        Boolean aBoolean = checkTime("2021-06-17 12:45:01");
//        System.out.println(aBoolean);
        bianma();
    }

//    public static void main(String[] args) throws ParseException {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

//    }

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

    public static Boolean checkTime(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(time);
        //上次获取时间
        long beforetime = parse.getTime();
        //现在时间
        long nowtime = System.currentTimeMillis();
        //两个小时的毫秒值
        long chazhi = 2 * 60 * 60 * 1000;
        if((nowtime - beforetime) > chazhi){
            return true;
        }else{
            return false;
        }

    }
    public static String geturl() {
        String url = "https://small.lbapp.cn/#/rights/detail/3544?couponNo=O6N45VTFY32GO2LBJNHNTJJ24Y&assetCode=TYNIXYVK0MYBRGTV492VUIDLO0ESAG1XK2GM8S5OMIQ7OIAG02E6Y9AI637U0OOY";
        int i = url.indexOf("#");
        String substring = url.substring(i+1);
        System.out.println(substring);
        return substring;
    }

    public static String bianma() {
        String url = "https://small.lbapp.cn/#/rights/detail/3544?couponNo=O6N45VTFY32GO2LBJNHNTJJ24Y&assetCode=TYNIXYVK0MYBRGTV492VUIDLO0ESAG1XK2GM8S5OMIQ7OIAG02E6Y9AI637U0OOY";
        //CharSequence charSequence = new CharSequence();
        String escape = EscapeUtil.escape(url);
        System.out.println(escape);
        return escape;
    }


    public static String getcode() {
        String url = "http://localhost:8081/?code=011in0000a0TUL1viK0003nNwX1in00s&state=#/auth/useropenid";
        int i = url.indexOf("&");

        System.out.println(i);
        int i1 = url.indexOf("=");
        System.out.println(i1);
        String substring = url.substring(i1+1, i);
        System.out.println(substring);
        return substring;
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
