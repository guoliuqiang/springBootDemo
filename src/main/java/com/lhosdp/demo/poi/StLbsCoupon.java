package com.lhosdp.demo.poi;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by goldratio on 20/11/2016.
 */
@Data
@Entity
@Table(name="st_lbs_coupon")
public class StLbsCoupon implements Serializable {


    @Id
    private String extCode;

    private String assetId;


    private Long expire;

    private String receiverId;

    private Date receiveTime;

    private String receiveChannel;

    private String code;

    private String shareCode;

    private String shelfBusiness;//发放货架所属机构

    private String consumerId;

    private Date consumeTime;

    private String consumeChannel;

    private String consumerFlowNo;

    private String handoutFlowNo;


}
