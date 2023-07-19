package com.lhosdp.demo.codestatistic;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelGroupDto {
//    @ApiModelProperty(value = "分组ID", required = true)
    String groupId;
//    @ApiModelProperty(value = "分组名称", required = true)
    String groupName;
//    @ApiModelProperty(value = "栏位集合", required = true)
    List<ChannelFieldDto> fields;

    public ChannelGroupDto(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }


}
