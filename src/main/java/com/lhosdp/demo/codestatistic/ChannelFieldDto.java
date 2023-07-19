package com.lhosdp.demo.codestatistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelFieldDto {

//    @ApiModelProperty(value = "栏位ID", required = true)
    String fieldId;
//    @ApiModelProperty(value = "栏位名称", required = true)
    String fieldName;
//    @ApiModelProperty(value = "槽位编号", required = true)
    int solt = 0;

}
