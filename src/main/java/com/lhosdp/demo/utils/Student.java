package com.lhosdp.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Student extends RestResponse{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Date date = new Date(1590732592 * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println("输出"+format);

    }
}
