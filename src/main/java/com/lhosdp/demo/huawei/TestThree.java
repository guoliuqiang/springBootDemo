package com.lhosdp.demo.huawei;

/**
 * 1. class A {
 * 2. protected int method1(int a, int b) { return 0; }
 * 3. }
 * Which two are valid in a class that extends class A? (Choose two)
 * A. public int method1(int a, int b) { return 0; }
 * B. private int method1(int a, int b) { return 0; }
 * C. private int method1(int a, long b) { return 0; }
 * D. public short method1(int a, int b) { return 0; }
 * E. static protected int method1(int a, int b) { return 0; }
 */



public class TestThree {

    protected int method1(int a, int b) { return 0; }
}

class B extends TestThree {

    /**
     * 重写方法  可见性不能降低，只能增加或者不变
     * @param a
     * @param b
     * @return
     */
    @Override
    protected int method1(int a, int b) { return 0; }

    /**
     * 重载方法
     * @param a
     * @param b
     * @return
     */
    private int method1(int a, long b) { return 0; }

    //static protected int method1(int a, int b) { return 0; }
}


/*
答案是A C

排除B   方法的可见性不能降低，只能增大或者不变
排除D   方法的返回值不同
排除E   静态方法不能够隐藏继承于A的实例，因为父类中的方法不是静态的，不能继承下来
 */

/**
 * 总结：类的继承中，如果要想重载父类的方法，必须要和父类中的返回类型、可见性等等都要操作一致
 *      *否则，程序就会报错。一定遵守子类要遵从于父类的原则
 *      *而我选择的答案居然是private int method1和static protected int
 *      *我选择第一个的错误理由是：因为原来为保护的，如果我这里设为public，那么就扩展了其原来的可见性
 *      *本来原来就是对包外不可见的，现在变成对包外可见的了，所以就选择的是private
 *      *选择第二个的错误理由是：都是保护的，这里只是变成了静态的而已
 *
 *
 *
 *      //这里是写了一个重载方法，因为参数类型不一致，不会报错
 *     privateint method1(int a, long b) { return 0; }
 *
 *     //可见性可以增大，但是不能够缩小，正确
 *     publicint method1(int a, int b) { return 0; }
 *
 */
