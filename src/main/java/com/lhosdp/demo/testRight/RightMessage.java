package com.lhosdp.demo.testRight;

import lombok.Data;

@Data
public class RightMessage {
    private String userId;
    /**
     * 前缀是ACTIVITY  活动，
     * 前缀是MISSION  任务
     * 前缀是MEMBER  会员权益
     */
    private String activityId;
    /**
     * 权益id/积分ID
     */
    private String equityId;
    /**
     * 权益类型 枚举值：COUPON（券）、INTEGRAL（积分）
     */
    private String equityType;
    /**
     * 权益/积分数量（中奖数量）
     */
    private Long winningNum;
    /**
     * 全局请求流水号
     */
    private String globalReqSerialNO;
    /**
     * 活动名称
     */
    private String title;
    /**
     * 过期时间戳
     */
    private Long expiredTime;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 活动所属机构ID
     */
    private String activityBusiness;

    /**
     * 奖项
     */
    private String award;
    /**
     * 营销活动带的traceId
     */
    private String marketTraceId;



    public RightMessage() {
    }


}
