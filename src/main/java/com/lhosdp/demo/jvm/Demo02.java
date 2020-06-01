package com.lhosdp.demo.jvm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 栈帧过大导致的内存溢出问题
 * 对象循环引用
 * @author guoliuqaing
 */
public class Demo02 {

    public static void main(String[] args) throws JsonProcessingException {

        Dept d = new Dept();
        d.setName("guoliuqiang");

        Emp e1 = new Emp();
        e1.setName("lisi");
        e1.setDept(d);

        Emp e2 = new Emp();
        e2.setName("wangwu");
        e2.setDept(d);

        d.setEmps(Arrays.asList(e1, e2));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(d));


    }


}
@Data
class Emp{
    private String name;
    /**
     * 忽略转换，可以排除循环引用
     */
    @JsonIgnore
    private Dept dept;
}
@Data
class Dept{
    private String name;
    private List<Emp> emps;
}

