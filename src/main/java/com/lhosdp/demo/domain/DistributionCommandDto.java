package com.lhosdp.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributionCommandDto {

    private String strategyId;//traceId=strategyId+"."+userId

    private Boolean forABTest = false;//是否AB测试策略
    private Integer diversionRadio = 100;//客群分流比例
    private String customerGroupType;//客群类型: ALL, WHITELIST, AUTO_LABEL, MANUAL_LABEL;
    private String customerGroup;//客群id，结合客群类型对应标签客群或白名单`
    private String cityAndBranch;//城市-网点

    private Boolean isRepeated = false;//是否周期性的
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;//开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;//结束时间
    private String period;//时间频率：WEEK, MONTH;
    private Integer periodDay = 1;//每周几、每月n日

    private String channel;//渠道
    private String field;//页面-栏位-顺序
    private String resourceType;//资源类型：AD, PROD, MENU;
    private String resourceId;//资源id

}
