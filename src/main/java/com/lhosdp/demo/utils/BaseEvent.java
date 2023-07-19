package com.lhosdp.demo.utils;

import java.io.Serializable;

public class BaseEvent implements Serializable {
    private String messageType;
    private String userId;
    private String distributionType;

    public BaseEvent() {
    }

    public BaseEvent(String messageType, String userId) {
        this.messageType = messageType;
        this.userId = userId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public MarketingEvent toMarketEvent(String strategyId) {
        return new MarketingEvent();
    }

}
