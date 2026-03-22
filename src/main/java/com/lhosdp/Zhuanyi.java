package com.lhosdp;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class Zhuanyi {


    public static void main(String[] args) {
        String str = "{\"actoutputList\":[{\"output\":\"{\"activity_id\":\"1002\",\"activity_link\":\"立即查看\",\"activity_name\":\"月月代发礼基金\",\"activity_time_period\":\"活动时间：2025.01.01-2025.11.30\",\"promotion_word\":\"本月发薪下月领奖，幸运大奖等您来拿\",\"status\":\"进行中\"}\"},{\"output\":\"{\"activity_id\":\"1007\",\"activity_link\":\"立即查看\\u003e\",\"activity_name\":\"借记卡嗨购季，消费随机立减最高10元理财\",\"activity_time_period\":\"活动时间：2024.12.01-2025.03.31\",\"promotion_word\":\"抖音、支付宝\",\"status\":\"进行中\"}\"},{\"output\":\"{\"activity_id\":\"1009\",\"activity_link\":\"立即查看\\u003e\",\"activity_name\":\"首绑领红包贵金属\",\"activity_time_period\":\"活动时间：2024.12.01-2025.03.31\",\"promotion_word\":\"恒丰借记卡\",\"status\":\"进行中\"}\"},{\"output\":\"{\"activity_id\":\"1003\",\"activity_link\":\"立即查看\\u003e\",\"activity_name\":\"邀新有礼黄金\",\"activity_time_period\":\"活动时间：2025.01.01-2025.12.31\",\"promotion_word\":\"最高可领1000元微信立减金\",\"status\":\"进行中\"}\"},{\"output\":\"{\"activity_id\":\"1005\",\"activity_link\":\"立即参与\\u003e\",\"activity_name\":\"一键绑卡领128元京东券包基金\",\"activity_time_period\":\"活动时间：2025.01.01-2025.06.30\",\"promotion_word\":\"借记卡、信用卡首绑礼\",\"status\":\"进行中\"}\"}],\"conversationSummary\":\"客户与小易的对话主要围绕理财产品和信用卡使用展开。客户首先询问了工资到账后的理财建议，随后关注了信用卡还款和资产情况。客户表达了对理财产品选择的不确定，并询问了其他人的购买情况。最后，客户询问了美团联名信用卡的网点信息，并预约了信用卡申请。\",\"customerMood\":\"犹豫与不确定\",\"customerScene\":\"理财咨询与信用卡申请\",\"customerWillingness\":[{\"Willingness_details\":\"客户对理财产品感兴趣，但不确定选择哪种产品。\",\"Willingness_level\":\"中需求\",\"holding_period\":[\"信息不足，无法判断\"],\"product_name\":\"未知\",\"product_style\":\"理财\",\"product_yield\":\"信息不足，无法判断\"}],\"intent_dislike_Tag\":[{\"risk_tag1\":\"信息不足，无法判断\",\"style_tag2\":\"信息不足，无法判断\"}],\"intent_like_Tag\":[\"理财\",\"信用卡\"],\"output\":\"\",\"output1\":\"\",\"output2\":\"\",\"outputList\":null,\"outputList1\":null,\"prooutputList1\":[{\"annual_yield_3m\":0,\"keywords\":\"热搜\",\"link\":\"www.belink.com\",\"minimum_purchase\":0,\"product_id\":\"2000000002\",\"product_name\":\"（财私专属）理财宝3号2021年66期个人理财\",\"product_type\":\"理财\",\"risk_level\":\"低风险\",\"status\":\"在售\",\"suitable_people\":\"车友用户\"},{\"annual_yield_3m\":0,\"keywords\":\"热搜\",\"link\":\"www.belink.com\",\"minimum_purchase\":0,\"product_id\":\"2000000004\",\"product_name\":\"（代发专属）理财宝2号2021年329期个人理财\",\"product_type\":\"理财\",\"risk_level\":\"低风险\",\"status\":\"在售\",\"suitable_people\":\"VIP用户\"}],\"purchasePlan\":[{\"pur_product_amount\":\"信息不足，无法判断\",\"pur_product_name\":\"未知\",\"pur_product_style\":\"理财\",\"pur_product_time\":\"信息不足，无法判断\"}],\"reasoning_content\":\"\",\"talk_channel\":\"AI手机银行\",\"talk_time\":\"2025-03-11 \",\"todoItem\":[{\"item_name\":\"信用卡申请预约\",\"item_operation\":\"预约\",\"item_operator\":\"小易\",\"item_time\":\"2025-03-12 10:00\",\"todo_discribe_detail\":\"预约西小口网点申请美团联名信用卡\"}]}";

        JSONObject entries = JSONUtil.parseObj(str);

        //输出
        for (String key : entries.keySet()) {
            System.out.println(key + ": " + entries.get(key));
        }
    }

}
