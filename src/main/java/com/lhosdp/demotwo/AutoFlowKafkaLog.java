package com.lhosdp.demotwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AutoFlowKafkaLog {

    private Integer id;

    private String day;

    private String createTime;

    private String logLevel;

    private String logger;

    private String msg;


}
