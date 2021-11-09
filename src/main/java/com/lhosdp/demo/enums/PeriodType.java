package com.lhosdp.demo.enums;

public enum PeriodType implements PushEnum {

    WEEK("周"),
    MOUTH("月");

    private String name;

    PeriodType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
