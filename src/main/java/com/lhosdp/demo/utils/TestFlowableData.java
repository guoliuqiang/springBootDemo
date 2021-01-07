package com.lhosdp.demo.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.UUID;

public class TestFlowableData {

    public static void main(String[] args) {

//        Long starttime1 = 1605235240509L;
//        Long endtime1 = 1605235495664L;
//        Long starttime2 = 1605235241582L;
//        Long endtime2 = 1605235495487L;
//        Long starttime3 = 1605235241588L;
//        Long endtime3 = 1605235490772L;
//        Long starttime4 = 1605236686916L;
//
//        Long endtime4 = 1605237467590L;
//        Long starttime5 = 1605236691480L;
//        Long endtime5 = 1605237442433L;
//
//        Long starttime1 = 1605249617280L;
//        Long endtime1 = 1605249988643L;
//        Long starttime2 = 1605249618646L;
//        Long endtime2 = 1605249988564L;
//        Long starttime3 = 1605249618677L;
//        Long endtime3 = 1605249986295L;
//        Long starttime4 = 1605250888171L;
//        Long endtime4 = 1605254690899L;
//        Long starttime5 = 1605250896761L;
//        Long endtime5 = 1605254690728L;
//
//        Long starttime1 = 1605491590401L;
//        Long endtime1 = 1605492079012L;
//        Long starttime2 = 1605491591544L;
//        Long endtime2 = 1605492078849L;
//        Long starttime3 = 1605491591679L;
//        Long endtime3 = 1605492076314L;
//        Long starttime4 = 1605492884430L;
//        Long endtime4 = 1605498415283L;
//        Long starttime5 = 1605492893865L;
//        Long endtime5 = 1605498415006L;
//
//        System.out.println(endtime1 - starttime1);
//        System.out.println(endtime2 - starttime2);
//        System.out.println(endtime3 - starttime3);
//        System.out.println(endtime4 - starttime4);
//        System.out.println(endtime5 - starttime5);


        System.out.println(UUID.randomUUID().toString());
        System.out.println(DateUtils.addDays(new Date(), 10).getTime());
        String querywinning = "AvtivityWinningQueryTask.execute(execution,";
        String express = "AvtivityWinningQueryTask.execute(execution, 'ddd')";
        String substring = express.substring(querywinning.length() + 2, express.length() - 2);
        System.out.println(substring);

    }
}
