package com.lhosdp.demo.rocket;

public class RightMessage {
    private String userId;
    private String activityId;//活动id 前缀是ACTIVITY为活动，MISSION为任务
    private String equityId;//权益id
    private String equityType;//权益类型 枚举值：COUPON（券）、INTEGRAL（积分）
    private Long winningNum;//权益数量（中奖数量）
    private String globalReqSerialNO;//全局请求流水号
    private String title;//活动名称
    private Long expiredTime;//过期时间戳

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Long getWinningNum() {
        return winningNum;
    }

    public void setWinningNum(Long winningNum) {
        this.winningNum = winningNum;
    }

    public String getGlobalReqSerialNO() {
        return globalReqSerialNO;
    }

    public void setGlobalReqSerialNO(String globalReqSerialNO) {
        this.globalReqSerialNO = globalReqSerialNO;
    }

    public String getEquityType() {
        return equityType;
    }

    public void setEquityType(String equityType) {
        this.equityType = equityType;
    }

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }
}
