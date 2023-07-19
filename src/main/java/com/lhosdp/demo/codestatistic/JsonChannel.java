package com.lhosdp.demo.codestatistic;

import com.lhosdp.demo.testRight.SmartLifeUtil;

import java.util.List;

public class JsonChannel {

    public static void main(String[] args) {
        String json = "[\n" +
                "    {\n" +
                "      \"channelId\": \"1\",\n" +
                "      \"channelName\": \"小程序\",\n" +
                "      \"channelType\": \"MINIPROGRAM\",\n" +
                "      \"pages\": [\n" +
                "        {\n" +
                "          \"groupId\": \"1\",\n" +
                "          \"groupName\": \"精彩生活首页\",\n" +
                "          \"fields\": [\n" +
                "            {\n" +
                "              \"fieldId\": \"1\",\n" +
                "              \"fieldName\": \"社区生活栏位\",\n" +
                "              \"solt\": 0\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"groupId\": \"4\",\n" +
                "          \"groupName\": \"便民服务\",\n" +
                "          \"fields\": [\n" +
                "            {\n" +
                "              \"fieldId\": \"3\",\n" +
                "              \"fieldName\": \"生活服务\",\n" +
                "              \"solt\": 0\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"channelId\": \"2\",\n" +
                "      \"channelName\": \"公众号\",\n" +
                "      \"channelType\": \"PUBLIC\",\n" +
                "      \"pages\": [\n" +
                "        {\n" +
                "          \"groupId\": \"2\",\n" +
                "          \"groupName\": \"惠民贷\",\n" +
                "          \"fields\": [\n" +
                "            {\n" +
                "              \"fieldId\": \"2\",\n" +
                "              \"fieldName\": \"农业贷款\",\n" +
                "              \"solt\": 0\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"groupId\": \"3\",\n" +
                "          \"groupName\": \"商业贷\",\n" +
                "          \"fields\": [\n" +
                "            {\n" +
                "              \"fieldId\": \"4\",\n" +
                "              \"fieldName\": \"消费商业贷\",\n" +
                "              \"solt\": 0\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]";

        List<ChannelDto> channelDtos = SmartLifeUtil.parseJsonList(json, ChannelDto.class);

        System.out.println(channelDtos);
    }
}
