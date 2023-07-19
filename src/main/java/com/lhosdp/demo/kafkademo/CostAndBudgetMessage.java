package com.lhosdp.demo.kafkademo;


import java.io.Serializable;

public class CostAndBudgetMessage implements Serializable {

    private String userId;
    private String strategyId;
    private String refId;
    private String messageType; //发放权益或者是消费权益
    private long turnover;    //交易额
    private String assetId;  //资产id
    private long time;  //发送时间
    private long budget;    //预算
    private long cost;  //使用权益的成本

    public CostAndBudgetMessage() {
    }

    public CostAndBudgetMessage(String userId, String strategyId, String refId, String messageType, long turnover, String assetId, long time, long budget, long cost) {
        this.userId = userId;
        this.strategyId = strategyId;
        this.refId = refId;
        this.messageType = messageType;
        this.turnover = turnover;
        this.assetId = assetId;
        this.time = time;
        this.budget = budget;
        this.cost = cost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public long getTurnover() {
        return turnover;
    }

    public void setTurnover(long turnover) {
        this.turnover = turnover;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }


}
