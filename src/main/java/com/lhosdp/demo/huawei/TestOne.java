package com.lhosdp.demo.huawei;


/**
 * 这里changeStr虽然是一个静态方法，但是里面的变量是一个局部变量
 */
public class TestOne {


    public static void changeStr(String str){
        str = "sdjflaslkdf";
    }

    public static void main(String[] args) {
        String str = "123";
        changeStr(str);
        System.out.println(str);
    }
}
