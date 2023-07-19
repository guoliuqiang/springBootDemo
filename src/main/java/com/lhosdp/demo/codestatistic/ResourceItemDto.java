package com.lhosdp.demo.codestatistic;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResourceItemDto {

//    @ApiModelProperty(value = "资源id", required = false)
    String id;
//    @ApiModelProperty(value = "资源名称", required = true)
    String name;
//    @ApiModelProperty(value = "资源类型", required = true)
    String type;//资源类型：AD, PROD, MENU;
//    @ApiModelProperty(value = "资源模板", required = true)
    String template;
//    @ApiModelProperty(value = "资源文本", required = false)
    String content;
//    @ApiModelProperty(value = "落地页链接", required = false)
    String pageUrl;
//    @ApiModelProperty(value = "图片链接", required = false)
    String imageUrl;//TODO 展示图片链接，适配渠道端
//    @ApiModelProperty(value = "关联活动、产品id", required = false)
    String referenceId;


    public ResourceItemDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ResourceItemDto(String id, String name, String referenceId) {
        this.id = id;
        this.name = name;
        this.referenceId = referenceId;
    }


}
