package com.lhosdp.demo.testRight;

public enum TransactionSource {

    NONE(null),
    EVENT("EV"),//活动
    MISSION("MI"),//任务
    RULE("RU"),//规则
    MEMBER("ME"),//会员
    GROWTH("GR");//成长值

    private String name;

    private TransactionSource(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



}
