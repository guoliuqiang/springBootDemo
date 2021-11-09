package com.lhosdp.demo.utils;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.HashUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhosdp.demo.domain.DistributionCommandDto;
import com.lhosdp.demo.domain.PublicData;
import com.lhosdp.demo.domain.PublicTempleRequest;

import java.util.*;

public class CommonUtilsTwo {

    public static void main(String[] args) {
//        String one = "CustomerUserList(id=22, customerGroupId=1397464496800403456, userName=韩涵涵, userId=200000001311, mobile=13552227295, sex=女, age=32, userType=游客, label=低收入人群, state=启用)";
//        gethashCode(one);
//        String two = "CustomerUserList(id=20, customerGroupId=1397464496800403456, userName=南难难, userId=100000001725, mobile=15901209729, sex=男, age=38, userType=游客, label=高收入人群, state=启用)";
//        gethashCode(two);
//        String three = "CustomerUserList(id=21, customerGroupId=1397464496800403456, userName=郭果果, userId=200000001181, mobile=13311201459, sex=男, age=27, userType=游客, label=中收入人群, state=启用)";
//        gethashCode(three);

//        String code = "MEMBER-5841006185125280-006";
//        String[] split = code.split("-");
//        String levelId = split[1];
//        String welfareId = split[2];
//        int i = DateUtil.ageOfNow("1996-12-03");
//        System.out.println(i);
//        gethashCode();
//        Boolean aBoolean = checkdayIsToday(3, "1,");
//
//        System.out.println(aBoolean);
        String businessId = "1100010";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < businessId.length(); i = i + 3) {
            String substring = businessId.substring(0, i + 3);
            list.add(substring);
        }
        System.out.println(list);
    }

    public static Boolean checkdayIsToday(int day, String days){
        String[] split = days.split(",");
        List list = Arrays.asList(split);
        boolean contains = list.contains(day + "");
        return contains;
    }

    private static void gethashCode(){
//        String one = "CustomerUserList(id=22, customerGroupId=1397464496800403456, userName=韩涵涵, userId=200000001311, mobile=13552227295, sex=女, age=32, userType=游客, label=低收入人群, state=启用)";
//        gethashCode(one);
//        String two = "CustomerUserList(id=20, customerGroupId=1397464496800403456, userName=南难难, userId=100000001725, mobile=15901209729, sex=男, age=38, userType=游客, label=高收入人群, state=启用)";
//        gethashCode(two);
//        String three = "CustomerUserList(id=21, customerGroupId=1397464496800403456, userName=郭果果, userId=200000001181, mobile=13311201459, sex=男, age=27, userType=游客, label=中收入人群, state=启用)";
//        gethashCode(three);
        //String one = "CustomerUserList(id=26, customerGroupId=1410124538355781632, userName=赵六六, userId=200000001151, mobile=18618288540, sex=女, age=15, userType=超级会员, label=低保户, state=启用)";
        String one = "200000001151";
        int res = HashUtil.oneByOneHash(one) % 100;
        System.out.println(Math.abs(res));

        //String san = "CustomerUserList(id=23, customerGroupId=1410124538355781632, userName=张三刀, userId=100000001725, mobile=15901209729, sex=男, age=12, userType=游客, label=高收入人群, state=启用)";
        String san = "100000001725";
        int ressan = HashUtil.oneByOneHash(san) % 100;
        System.out.println(Math.abs(ressan));

        //String si = "CustomerUserList(id=24, customerGroupId=1410124538355781632, userName=李四行, userId=200000001181, mobile=13311201459, sex=男, age=13, userType=常客, label=中收入人群, state=启用)";
        String si = "200000001181";
        int ressi = HashUtil.oneByOneHash(si) % 100;
        System.out.println(Math.abs(ressi));

        //String wu = "CustomerUserList(id=25, customerGroupId=1410124538355781632, userName=王五五, userId=200000001311, mobile=13552227295, sex=女, age=14, userType=会员, label=低收入人群, state=启用)";
        String wu = "200000001311";
        int reswu = HashUtil.oneByOneHash(wu) % 100;
        System.out.println(Math.abs(reswu));

//        int res = HashUtil.oneByOneHash(str) % 100;
//        System.out.println(Math.abs(res));
    }

    private static void testCommonandShuju(){
        DistributionCommandDto distributionCommandDto = new DistributionCommandDto();
        distributionCommandDto.setStrategyId("1");
        distributionCommandDto.setDiversionRadio(60);
        DistributionCommandDto distributionCommandDto1 = new DistributionCommandDto();
        distributionCommandDto1.setStrategyId("2");
        distributionCommandDto1.setDiversionRadio(40);
        DistributionCommandDto distributionCommandDto2 = new DistributionCommandDto();
        distributionCommandDto2.setStrategyId("3");
        distributionCommandDto2.setDiversionRadio(20);
        DistributionCommandDto distributionCommandDto3 = new DistributionCommandDto();
        distributionCommandDto3.setStrategyId("4");
        distributionCommandDto3.setDiversionRadio(50);

        ArrayList<DistributionCommandDto> list = new ArrayList<>();
        list.add(distributionCommandDto);
        list.add(distributionCommandDto1);
//        list.add(distributionCommandDto2);
//        list.add(distributionCommandDto3);
        Map<String, String> bili = new HashMap<>();
        Integer beforeradio = 0;
        for (int i = 0; i < list.size(); i++) {
            //上一个的末尾
            if(i == 0){
                DistributionCommandDto dto = list.get(i);
                Integer diversionRadio = dto.getDiversionRadio();
                bili.put(dto.getStrategyId(), "0-"+(diversionRadio-1));
                beforeradio = diversionRadio;
            }else{
                DistributionCommandDto dto = list.get(i);
                //本次的比例
                Integer diversionRadio = dto.getDiversionRadio();
                //判断是否是最后一个
                if(i == list.size()-1){
                    bili.put(dto.getStrategyId(), beforeradio + "-" + 99);
                }else{
                    bili.put(dto.getStrategyId(), beforeradio + "-" + (beforeradio + diversionRadio - 1));
                }
                beforeradio = beforeradio + diversionRadio;
            }
        }
        System.out.println(bili);

    }

    private static void testpublicmessage() throws JsonProcessingException {
        PublicData one = new PublicData();
//        one.setName("first");
        one.setValue("恭喜你预约成功！");
        one.setColor("#173177");
        PublicData two = new PublicData();
//        two.setName("keyword1");
        two.setValue("秒杀抢购");
        two.setColor("#173177");
        PublicData three = new PublicData();
//        three.setName("keyword2");
        three.setValue("每天早上八点");
        three.setColor("#173177");
        PublicData five = new PublicData();
//        five.setName("remark");
        five.setValue("愿您抢购成功！");
        five.setColor("#173177");

        PublicTempleRequest request = new PublicTempleRequest();
        request.setTouser("ooop86Sj2vg7PKZA1idapWwL1ICs");
        request.setTemplate_id("gQvXq6BE59NVwTRU-HmaC_lYo-zMKycBA0tU3poo8hs");
        request.setUrl("https://small.lbapp.cn/#/auth/forward");
        HashMap<String, PublicData> map = new HashMap<>();
        map.put("first", one);
        map.put("keyword1", two);
        map.put("keyword2", three);
        map.put("remark", five);
        request.setData(map);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(request);
        System.out.println(s);
    }



}
