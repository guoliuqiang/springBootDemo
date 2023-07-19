package com.lhosdp.demo.testRight;

import org.apache.commons.lang3.StringUtils;

public class TestRightunit {

    public static void main(String[] args) {
        String body = "{\"activityBusiness\":\"10000000\",\"activityId\":\"MEMBER-5841000608863648-003-7814725823770048\",\"equityId\":\"3627\",\"equityType\":\"COUPON\",\"expiredTime\":1650095023652,\"globalReqSerialNO\":\"8029887877959777\",\"marketTraceId\":436456455457,\"title\":\"人群运营(领权益)活动traceID测试02\",\"userId\":\"200000001627\",\"winningNum\":1}";
        RightMessage rightMessage = SmartLifeUtil.parseJson(body, RightMessage.class);
        //获取奖项
        String award = rightMessage.getAward();
        //获取活动ID
        String activityId = rightMessage.getActivityId();
        //ACTIVITY 活动ID-奖项包  MEMBER 传过来的activityId
        String activityIdAward = "";
        //判断是不是会员权益
        int member = rightMessage.getActivityId().indexOf("MEMBER");
        TransactionSource source = TransactionSource.EVENT;
        if(member > -1){
            source = TransactionSource.MEMBER;
            activityIdAward = rightMessage.getActivityId();
        }else{
            if(!StringUtils.isEmpty(award)){
                activityIdAward = rightMessage.getActivityId() + "-" + award;
            }else{
                activityIdAward = activityId;
            }
        }
        System.out.println(activityId);
        System.out.println(activityIdAward);
        System.out.println(source);
    }
}
