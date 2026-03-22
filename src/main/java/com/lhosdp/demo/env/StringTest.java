package com.lhosdp.demo.env;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StringTest {

    public static void main(String[] args) {

        // 创建一个列表，里面是部门信息
        List<String> deptList = new ArrayList<>();
        deptList.add("一级部门");
        deptList.add("二级部门");
        deptList.add("三级部门");
        deptList.add("四级部门");
        //移除列表中的第一个元素
//        deptList.remove(0);
//
//        String result = String.join("/", deptList);
//        System.out.println(result);

        //反转列表
        List<String> reverseList = new ArrayList<>();
        for (int i = deptList.size() - 1; i >= 0; i--) {
            reverseList.add(deptList.get(i));
        }


    }
}
