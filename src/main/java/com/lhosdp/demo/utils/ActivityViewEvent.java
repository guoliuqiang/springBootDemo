package com.lhosdp.demo.utils;


public class ActivityViewEvent extends TraceEvent {
    private String refId;//活动id
    private String time;//查看时间

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MarketingEvent toMarketEvent(String strategyId, String activityId) {
        MarketingEvent event = new MarketingEvent();
        event.setMessageType("ACTIVITY_VIEW");
        event.setUserId(this.getUserId());
        event.setStrategyId(strategyId);
        event.setRefId(activityId);
        return event;
    }
}
