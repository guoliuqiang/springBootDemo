package com.lhosdp.demo.utils;

public enum ChartSet {
    GBK("GBK", 2),
    GB2312("GB2312", 2),
    UTF8("UTF-8", 3),
    UNICODE("Unicode", 4),
    ;
    private String value;
    /*
     中文所占字节
     */
    private int bytes;

    private ChartSet(String value, Integer bytes){
        this.value = value;
        this.bytes = bytes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
