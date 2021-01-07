package com.lhosdp.demo.utils;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryEvent {

    private String code;
    private Long batchNumber;
    private Long number;
    private Date createTime;

    public InventoryEvent() {
    }

    public InventoryEvent(String code, Long batchNumber, Long number, Date createTime) {
        this.code = code;
        this.batchNumber = batchNumber;
        this.number = number;
        this.createTime = createTime;
    }
}
