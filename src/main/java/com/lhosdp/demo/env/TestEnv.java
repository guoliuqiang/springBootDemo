package com.lhosdp.demo.env;

import com.lhosdp.demo.testRight.SmartLifeUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import scala.Int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEnv {

    //订单查证次数，需要查证三次都是失败，才能判断是真的失败了
    private static Map<String, Integer> orderFailedmap = new HashMap<>();
    private static String[] red = {"01", "02","03","04","05","06","07","08","09","10",
                                    "11","12","13","14","15","16","17","18","19","20",
                                    "21","22","23","24","25","26","27","28","29","30"
                                    ,"31","32","33",};
    private static String[] blue = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16"};
    //然后蓝球是从1-16中抽取一个数字

    public static void main(String[] args) {

        for (int j = 0; j < 4; j++) {
            List<String> shuangseqiu1 = new ArrayList<>();
            //六个红色球
            for (int i = 0; i < 6; i++) {
                Double index = Math.floor(Math.random() * 30);
                final String number = red[index.intValue()];
                if(shuangseqiu1.contains(number)){
                    Double index2 = Math.floor(Math.random() * 30);
                    shuangseqiu1.add(red[index2.intValue()]);
                }else{
                    shuangseqiu1.add(red[index.intValue()]);
                }
            }
            //一个蓝色球
            Double index3 = Math.floor(Math.random() * 16);
            shuangseqiu1.add(blue[index3.intValue()]);
            System.out.println(shuangseqiu1);
        }



    }

    private static Boolean checkFailedNumber(String orderId){
        System.out.println(orderFailedmap.toString());
        //判断是否已经失败过
        final boolean isSave = orderFailedmap.containsKey(orderId);
        if(isSave){
            //存在
            Integer failedNumber = orderFailedmap.get(orderId);
            if(failedNumber > 3){
                return true;
            }else{
                failedNumber += 1;
                orderFailedmap.put(orderId, failedNumber);
                return false;
            }
        }else{
            //不存在
            orderFailedmap.put(orderId, 1);
            return false;
        }
    }
}
