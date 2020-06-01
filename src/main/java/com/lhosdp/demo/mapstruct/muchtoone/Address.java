package com.lhosdp.demo.mapstruct.muchtoone;

import lombok.Data;

/**
 * @author guoliuqaing
 */
@Data
public class Address {

    private String street;
    private int zipCode;
    private int houseNo;
    private String description;
}
