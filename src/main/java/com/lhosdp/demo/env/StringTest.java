package com.lhosdp.demo.env;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.UUID;

public class StringTest {

    public static void main(String[] args) {
//        String str = "{\"channelData\":{},\"bodyData\":{\"eventId\":\"2022101015051600059207\",\"data\":\"{\\\"addLog\\\":true,\\\"bizChannel\\\":\\\"MB\\\",\\\"channelSort\\\":\\\"SS\\\",\\\"checkResult\\\":true,\\\"cumulativeFlag\\\":false,\\\"cycleComplete\\\":false,\\\"elementList\\\":[{\\\"elementCode\\\":\\\"sendTime\\\",\\\"elementName\\\":\\\"发送时间\\\",\\\"elementShowType\\\":\\\"input\\\",\\\"elementShowValue\\\":\\\"\\\",\\\"elementSort\\\":\\\"000\\\",\\\"elementType\\\":\\\"001\\\",\\\"elementValueType\\\":\\\"I\\\",\\\"eventCode\\\":\\\"000004\\\",\\\"productCode\\\":\\\"10045\\\",\\\"targetField\\\":\\\"sendTime\\\"}],\\\"eventCode\\\":\\\"000004\\\",\\\"eventId\\\":\\\"2022101015051600059207\\\",\\\"firstFlag\\\":false,\\\"flowId\\\":1579389071866728449,\\\"matchType\\\":0,\\\"nonCumulativeFlagMatch\\\":true,\\\"paramMap\\\":{\\\"sendTime\\\":1665390672904},\\\"productCode\\\":\\\"10045\\\",\\\"progressId\\\":1579389072844001282,\\\"recordList\\\":[{\\\"bizChannel\\\":\\\"MB\\\",\\\"channelSort\\\":\\\"SS\\\",\\\"eventCode\\\":\\\"000004\\\",\\\"flowId\\\":1579389071866728449,\\\"globalReqSerialNo\\\":\\\"16653906729051579389071384514560\\\",\\\"productCode\\\":\\\"10045\\\",\\\"reqSerialNo\\\":\\\"c8dba02ae5774eca9b51ff292b9bbfdd\\\",\\\"rollback\\\":false,\\\"tradeElement\\\":\\\"{\\\\\\\"traceId\\\\\\\":\\\\\\\"48s45df48es5ff4e84f8e\\\\\\\",\\\\\\\"bizChannel\\\\\\\":\\\\\\\"MB\\\\\\\",\\\\\\\"messageType\\\\\\\":\\\\\\\"EQUITY_RECEIVE\\\\\\\",\\\\\\\"businessGroup\\\\\\\":\\\\\\\"00\\\\\\\",\\\\\\\"channelSort\\\\\\\":\\\\\\\"SS\\\\\\\",\\\\\\\"refId\\\\\\\":\\\\\\\"LEBO4NCU4ZG3RTJKEJK2S7R9SJA1OIQF8E7LQ9LBKQIFDSL45LLJRDIFLXTCZ0RR\\\\\\\",\\\\\\\"userId\\\\\\\":\\\\\\\"4548725110\\\\\\\",\\\\\\\"sendTime\\\\\\\":1665390672904}\\\",\\\"tradeState\\\":\\\"01\\\",\\\"tradeTime\\\":\\\"20221010163113\\\",\\\"userId\\\":\\\"4548725110\\\"}],\\\"requireList\\\":[{\\\"checkResult\\\":true,\\\"elementCode\\\":\\\"sendTime\\\",\\\"elementType\\\":\\\"001\\\",\\\"elementValueType\\\":\\\"I\\\",\\\"endDate\\\":\\\"\\\",\\\"maxSymbol\\\":\\\">\\\",\\\"maxValue\\\":\\\"0\\\",\\\"minSymbol\\\":\\\"\\\",\\\"minValue\\\":\\\"\\\",\\\"periodType\\\":\\\"\\\",\\\"startDate\\\":\\\"\\\"}],\\\"rollback\\\":false,\\\"ruleId\\\":\\\"2022101015051600059208\\\",\\\"tradeRecordDO\\\":{\\\"$ref\\\":\\\"$.recordList[0]\\\"},\\\"tradeTime\\\":\\\"20221010163113\\\",\\\"userId\\\":\\\"4548725110\\\"}\",\"tradeNo\":1579389072844001282,\"relationId\":\"1001\",\"type\":\"COUPON\",\"userId\":\"4548725110\"},\"reqHeaderData\":{\"deviceInfoData\":{\"locationInfo\":{}}}}";
//
//        JSONObject jsonObject = JSON.parseObject(str);
//        JSONObject bodyData = jsonObject.getJSONObject("bodyData");
//        JSONObject data = bodyData.getJSONObject("data");
//        JSONArray recordList = data.getJSONArray("recordList");
//        JSONObject record = recordList.getJSONObject(0);
//        JSONObject tradeElement = record.getJSONObject("tradeElement");
//
//        /**
//         * {\\\"traceId\\\":\\\"48s45df48es5ff4e84f8e\\\",
//         * \\\"bizChannel\\\":\\\"MB\\\",
//         * \\\"messageType\\\":\\\"EQUITY_RECEIVE\\\",
//         * \\\"businessGroup\\\":\\\"00\\\",
//         * \\\"channelSort\\\":\\\"SS\\\",
//         * \\\"refId\\\":\\\"LEBO4NCU4ZG3RTJKEJK2S7R9SJA1OIQF8E7LQ9LBKQIFDSL45LLJRDIFLXTCZ0RR\\\",
//         * \\\"userId\\\":\\\"4548725110\\\",
//         * \\\"sendTime\\\":1665390672904}\",
//         */
//
//        final String traceId = tradeElement.getString("traceId");
//        System.out.println(traceId);
//        final String messageType = tradeElement.getString("messageType");
//        System.out.println(messageType);
//        final String refId = tradeElement.getString("refId");
//        System.out.println(refId);
//        final String userId = tradeElement.getString("userId");
//        System.out.println(userId);
//        final String sendTime = tradeElement.getString("sendTime");
        System.out.println(UUID.randomUUID().toString());



    }
}
