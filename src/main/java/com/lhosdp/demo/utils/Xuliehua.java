package com.lhosdp.demo.utils;

import java.io.*;

public class Xuliehua {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            //序列化
            System.out.println("序列化");
            FileOutputStream fos = new FileOutputStream("object.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Student student1 = new Student("lihao");
//            oos.writeObject(new RestResponse(student1));
            oos.writeObject(student1);
            oos.flush();
            oos.close();
            System.out.println("反序列化");
            //反序列化
            FileInputStream fis = new FileInputStream("object.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student2 = (Student) ois.readObject();
            System.out.println(student2.getName());
    }
}
