package com.ynet.canvas.service.dto.list;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import java.io.Serializable;

@Data
@Tag(name = "客群参数列表", description = "客群列表")
public class GroupList implements Serializable {
    private static final long serialVersionUID = -8164228491148318376L;
    @Schema(description = "画布分支ID")
    private String nodeId;
    @Schema(description = "客群ID")
    private String groupId;

    @Schema(description = "客群交互规则：1:满足【交集】 2:不满足【差集】,默认满足")
    private String condition = "1";

}
