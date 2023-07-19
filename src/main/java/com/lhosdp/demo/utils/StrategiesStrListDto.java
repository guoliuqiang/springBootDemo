package com.lhosdp.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategiesStrListDto {

    /*

    {"栏位id":
  [
    {"slotIndex":"0","resourceId":36633,"resourceName":"标版icon-尊享权益","strategyType":"normal","modelId":"1","strategies":{},"modelName":""},
  ]
}
     */
    private String slotIndex;
    private String resourceId;
    private String resourceName;
    private String strategyType = "normal";
    private String modelId = "1";
    private Demo strategies = new Demo();
    private String modelName = "";

    public StrategiesStrListDto(String slotIndex, String resourceId, String resourceName) {
        this.slotIndex = slotIndex;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }
}
