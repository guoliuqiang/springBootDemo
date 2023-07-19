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

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLOutput;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class CommonUtils {

    public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
//        String str = "{\"bizId\":1320640668583985531,\"tunnelNo\":\"11\",\"tunnelName\":\"微信小程序\",\"tunnelUrl\":null,\"tunnelTemplateId\":\"MQF45Ed3r1mFSkDWypiC9ESUaVPVwCNkjrTcK011_hk\",\"tunnelTemplateName\":\"节日祝福提醒-权益营销微信小程序\",\"templateNo\":\"7924599707776160\",\"templateTitle\":\"节日祝福提醒\",\"templateContent\":\"节日 #thing1:${payerAccountName}#\\n祝福语 #thing2:${payeeAccountName}#\",\"templateExample\":null,\"templateType\":\"1\",\"status\":\"0\",\"templateName\":\"权益营销小程序消息推送\",\"opId\":null,\"remark\":\"\",\"billPicUrl\":\"\",\"billLink\":\"${linkUrl}\",\"msgRecommend\":null,\"templateMsgType\":\"0\",\"templateSummary\":\"\",\"msgText\":\"\",\"extendedParams\":null,\"channelCode\":\"QY-YX\",\"channelName\":\"权益营销\",\"attachment\":null,\"signature\":null,\"templateStyle\":\"1\",\"btnText\":\"查看详情\"}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        MiniTemplateJson o = objectMapper.readValue(str, MiniTemplateJson.class);
//        TemplateSaveText templateSaveText = objectMapper.readValue(str, TemplateSaveText.class);

        //https://dev.lbapp.cn/game/game_sign_normal/index.html?acId=7947249369727744
        String sr = "https://dev.lbapp.cn/game/game_sign_normal/index.html?acId=7947249369727744";
        //String src = "{\"content\":\"测试\",\"imageUrl\":\"https://dev.lbapp.cn/fastdfs/groupfinmallpro/M00/00/00/t4YBAGI6exKAchB1AAAPt3ltXLc833.png\",\"pageUrl\":\"https://small.lbapp.cn/#/spree/receive/138IA5L90GEK/6\"}";
        String encode = URLEncoder.encode(sr, "UTF-8");

        URLDecoder.decode("https%3A%2F%2Fdev.lbapp.cn%2Fgame%2Fgame_sign_normal%2Findex.html%3FacId%3D7947249369727744");

        System.out.println(encode);

    }

/*





 */

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
