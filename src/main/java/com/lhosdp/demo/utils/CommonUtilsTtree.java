package com.lhosdp.demo.utils;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CommonUtilsTtree {

    public static void main(String[] args) {
        Date startTime =  DateUtils.addDays(new Date(), 2);
        Date startUpTime = DateUtils.addDays(new Date(), 1);
        if(startUpTime == null || startUpTime.getTime() > startTime.getTime()){
            System.out.println("设置开始时间");
        }else{
            System.out.println("不设置开始时间");
        }
    }


    private static void toStringMethod(int[] arr)
    {
        // 自定义一个字符缓冲区，
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        //遍历int数组，并将int数组中的元素转换成字符串储存到字符缓冲区中去
        for(int i=0;i<arr.length;i++)
        {
            if(i!=arr.length-1)
                sb.append(arr[i]+" ,");
            else
                sb.append(arr[i]+" ]");
        }
        System.out.println(sb);
    }


    private void sdflsd(){
        Date createTime = DateUtils.addDays(new Date(), -9);
        //Date createTime = new Date();
        ArrayList<String> datelist = new ArrayList<>();
        //创建时间
        String createDate = DateUtil.formatDate(createTime);
        //当前天
        String today = DateUtil.today();
        long betweenDay = DateUtil.between(createTime, DateUtil.date(), DateUnit.DAY);
        System.out.println("创建时间和当前时间相差天数："+ betweenDay);
        if(createDate.equals(today)){
            datelist.add(today);
        }else{
            //datelist.add(today);
            //循环添加相差天数
            betweenDay = betweenDay + 1;
            if(betweenDay >= 8){
                betweenDay = 7;
            }
            for (int i = 0; i < betweenDay; i++) {
                Date date = DateUtils.addDays(new Date(), -i);
                datelist.add(DateUtil.formatDate(date));
            }
        }


        System.out.println(datelist);
    }




}
