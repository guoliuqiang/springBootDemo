package com.lhosdp.demo.codestatistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {

    //客户姓名
    @Column(name = "consumer_name")
    private String consumerName;

}
