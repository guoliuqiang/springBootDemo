package com.lhosdp.demo.jvm;

/**
 * 测试虚拟机栈
 *
 * @author guoliuqaing
 */
public class DemoJVM2 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b);
    }

    private static void method(int a, int b) {
        a += 10;
        b += 20;
        method2(a, b);
    }

    private static void method2(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }


}
