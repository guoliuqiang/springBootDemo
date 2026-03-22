package com.lhosdp;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestCreateFile {
    public static void main(String[] args) {

        String nodeList = "[{\"nodeId\": \"gp-前端定义-gpb-前端定义\",   \"groupId\": \"客群ID--页面配置\",   \"condition\": \"1\" }, {   \"nodeId\": \"gp-前端定义-gpb-前端定义\",   \"groupId\": \"客群ID--页面配置\",   \"condition\": \"1\" }]";
//        log.info("在这里判断 如果分支节点没有选择客群的话，不走分流流程，直接将上游的文件传递到下游即可，直接返回即可");
        ObjectMapper objectMapper = new ObjectMapper();
        Boolean fenliu = false;
        List<GroupList> groupLists = new ArrayList<>();
        try {
            groupLists = objectMapper.readValue(nodeList, new TypeReference<List<GroupList>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (GroupList groupList: groupLists) {
            //有一个不是null的，就走分流流程
            //有一个不是null的，就不走分流流程
            if(StrUtil.isNotEmpty(groupList.getGroupId())){
                fenliu = true;
                //跳出循环
                break;
            }
        }
//        log.info("判断完成，nofenliu={}", nofenliu);
        System.out.println(fenliu);
    }

}