package com.lhosdp.demo.codestatistic;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {
//    @ApiModelProperty(value = "渠道ID", required = true)
    String channelId;
//    @ApiModelProperty(value = "渠道名称", required = true)
    String channelName;
//    @ApiModelProperty(value = "渠道类型", required = true)
    String channelType;
//    @ApiModelProperty(value = "分组集合", required = true)
    List<ChannelGroupDto> pages;

    public ChannelDto(String channelId, String channelName, List<ChannelGroupDto> pages) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.pages = pages;
    }
}
