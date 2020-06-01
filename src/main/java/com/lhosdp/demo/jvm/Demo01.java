package com.lhosdp.demo.jvm;

/**
 * 栈帧过多导致的栈内存溢出
 * 测试java.lang.StackOverflowError
 *
 * @author guoliuqaing
 * 设置jvm参数  在VM options中设置
 * -Xss256k  次数减少
 * -Xss10m: 次数变多
 */
public class Demo01 {

    private static int count;

    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("count:" + count);
        }
    }

    private static void method() {
        count++;
        //每次调用一次方法都会产生一个栈帧
        method();
    }
}
