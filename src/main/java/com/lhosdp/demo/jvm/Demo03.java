package com.lhosdp.demo.jvm;

/**
 * 堆内存诊断
 * @author guoliuqaing
 *
 * jps : 查看当前系统中有哪些java进程
 * jmap工具：查看堆内存占用情况（某一个时刻）
 * jmap -heap 进程id
 *
 * jconsole工具： 图形界面的，内置java性能分析器，多功能的检测工具，可以连续监测
 */
public class Demo03 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.........");
        Thread.sleep(30000);
        byte[] bys = new byte[1024 * 1024 * 10];
        System.out.println("2..........");
        Thread.sleep(10000);
        bys = null;
        System.gc();
        System.out.println("3..........");
        Thread.sleep(1000000);


    }
}
