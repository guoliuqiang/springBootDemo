package com.lhosdp.demo.codestatistic;

import com.lhosdp.demo.testRight.SmartLifeUtil;

import java.util.List;

public class Jsonzhunhaun {

    public static void main(String[] args) {

        String json = "[\n" +
                "        {\n" +
                "          \"id\": \"234\",\n" +
                "          \"name\": \"9-6新活动\",\n" +
                "          \"type\": \"AD\",\n" +
                "          \"template\": null,\n" +
                "          \"content\": \"11\",\n" +
                "          \"pageUrl\": \"https://small.lbapp.cn/#/spree/receive/X18LSR6TWO0S/6\",\n" +
                "          \"imageUrl\": null,\n" +
                "          \"referenceId\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"235\",\n" +
                "          \"name\": \"0823营销活动\",\n" +
                "          \"type\": \"AD\",\n" +
                "          \"template\": null,\n" +
                "          \"content\": \"9月1\",\n" +
                "          \"pageUrl\": \"https://small.lbapp.cn/#/spree/receive/LPOJIL5143G5/6\",\n" +
                "          \"imageUrl\": \"https://dev.lbapp.cn/fastdfs/groupdev/M00/00/04/qoYBAGFL6lCAXMwoAAAqG5pjh2I2512960\",\n" +
                "          \"referenceId\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"236\",\n" +
                "          \"name\": \"9-6新活动\",\n" +
                "          \"type\": \"AD\",\n" +
                "          \"template\": null,\n" +
                "          \"content\": \"第一次\",\n" +
                "          \"pageUrl\": \"https://small.lbapp.cn/#/spree/receive/X18LSR6TWO0S/6\",\n" +
                "          \"imageUrl\": \"https://dev.lbapp.cn/fastdfs/groupdev/M00/00/04/qYYBAGFMFFqAcNVGAABKCl3MHB86555457\",\n" +
                "          \"referenceId\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"322\",\n" +
                "          \"name\": \"权益发放活动\",\n" +
                "          \"type\": \"AD\",\n" +
                "          \"template\": null,\n" +
                "          \"content\": \"mock测试\",\n" +
                "          \"pageUrl\": \"https://small.lbapp.cn/#/spree/receive/138IA5L90GEK/6\",\n" +
                "          \"imageUrl\": \"https://dev.lbapp.cn/fastdfs/groupdev/M00/00/0E/qYYBAGIy5bWAAReAAAAPt3ltXLc337.png\",\n" +
                "          \"referenceId\": null\n" +
                "        }\n" +
                "      ]";

        final List<ResourceItemDto> resourceItemDtos = SmartLifeUtil.parseJsonList(json, ResourceItemDto.class);

        System.out.println(resourceItemDtos.size());
    }

}
