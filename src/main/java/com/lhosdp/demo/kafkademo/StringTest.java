package com.lhosdp.demo.kafkademo;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
//        converjson("123123","EQUITY_CONSUME",
//                "ssssadsfa","adfweefa",
//                "1236",
//                159L,369L, 50036L);
//
//        String str = "{'cost':159,'messageType':'EQUITY_CONSUME','assetId':'1236','strategyId':'adfweefa','refId':'ssssadsfa','time':1637138344605,'userId':'123123','turnover':50036,'budget':369}";
//        String substring = str.substring(1, str.length() - 1);
//        System.out.println(substring);

//        CostAndBudgetMessage message = new CostAndBudgetMessage();
//        message.setUserId("234234");
//        message.setMessageType("EQUITY_CONSUME");
//        message.setRefId("343434");
//        message.setStrategyId("55555");
//        message.setAssetId("1564");
//        message.setCost(567L);
//        message.setBudget(45678L);
//        message.setTurnover(50000L);
//
//        //JSONObject jsonObject = new JSONObject();
//        String s = JSONObject.toJSONString(message);
//        System.out.println(s);
        List<String> actNoList = (List)(List) Arrays.asList(StrUtil.split("2222222222222222", StrUtil.DASHED));
        List<Long> actList = new ArrayList<Long>() ;
        for(String actNo : actNoList) {
            actList.add(Long.parseLong(actNo)) ;
        }
        System.out.println(actList);



    }

    //组装JSON
//    public static String converjson(String userId, String messageType,
//                             String refId, String strategyId,
//                             String assetId,
//                             long cost,long budget,long turnover ){
//        // 1. 创建JSON对象
//        JSONObject jsonObject = new JSONObject();
//
//        jsonObject.append("userId",userId)
//                .append("messageType",messageType)
//                .append("refId",refId)
//                .append("strategyId",strategyId)
//                .append("cost", cost)
//                .append("budget", budget)
//                .append("turnover", turnover)
//                .append("assetId", assetId).append("time",System.currentTimeMillis());
//        System.out.println(jsonObject.toString());
//
//        return jsonObject.toString();
//    }

    //组装JSON
    public static String converjson(String userId, String messageType,
                String refId, String strategyId,
                String assetId,
        long cost,long budget,long turnover){
        // 1. 创建JSON对象
        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        if(!org.apache.commons.lang3.StringUtils.isEmpty(userId)){
            jsonObject.put("userId", userId);
        }
        jsonObject.put("messageType", messageType);
        if(!org.apache.commons.lang3.StringUtils.isEmpty(refId)){
            jsonObject.put("refId", refId);
        }
        if(!org.apache.commons.lang3.StringUtils.isEmpty(strategyId)){
            jsonObject.put("strategyId", strategyId);
        }
        if(!org.apache.commons.lang3.StringUtils.isEmpty(assetId)){
            jsonObject.put("assetId", assetId);
        }
        jsonObject.put("cost", cost);
        jsonObject.put("budget", budget);
        jsonObject.put("turnover", turnover);
        jsonObject.put("time", System.currentTimeMillis());
        System.out.println(jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }
}
