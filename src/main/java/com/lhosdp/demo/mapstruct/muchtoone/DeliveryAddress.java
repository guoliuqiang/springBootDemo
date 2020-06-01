package com.lhosdp.demo.mapstruct.muchtoone;

import lombok.Data;

/**
 * @author guoliuqaing
 * 演示多转一操作，将Address和Person对象转成DeliveryAddress
 */
@Data
public class DeliveryAddress {

    private String firstName;
    private String lastName;
    private int height;
    private String street;
    private int zipCode;
    private int houseNumber;
    private String description;
}
