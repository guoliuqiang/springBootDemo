package com.lhosdp.demo.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Xuliehua {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
//            //序列化
//            System.out.println("序列化");
//            FileOutputStream fos = new FileOutputStream("object.out");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            Student student1 = new Student("lihao");
////            oos.writeObject(new RestResponse(student1));
//            oos.writeObject(student1);
//            oos.flush();
//            oos.close();
//            System.out.println("反序列化");
//            //反序列化
//            FileInputStream fis = new FileInputStream("object.out");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Student student2 = (Student) ois.readObject();
//            System.out.println(student2.getName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//当前时间
            Date now = new Date();
            //计算第二天开始时间
            Date startdate = DateUtils.addDays(now, 1);
            String start = simpleDateFormat.format(startdate);
            String substring = start.substring(0, 10);
            String concat = substring.concat(" 00:00:00");
            System.out.println(concat);
            //计算第七天的结束时间
            Date enddate = DateUtils.addDays(now, 7);
            String end = simpleDateFormat.format(enddate);
            String endsubstring = end.substring(0, 10);
            String endconcat = endsubstring.concat(" 23:59:59");
            System.out.println(endconcat);



    }
}
