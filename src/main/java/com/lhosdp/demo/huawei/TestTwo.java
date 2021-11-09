package com.lhosdp.demo.huawei;


/**
 * What is the result?
 * A. ABDCBDCB
 * B. ABCDABCD
 * C. Compilation fails.
 * D. An exception is thrown at runtime.
 */
public class TestTwo {

    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }
    public static void main(String[] argv) {
        int i = 0;
        //for(65;88&&(i<2);67)
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
     }
}

//第一次循环
// 执行（初始化语句）foo(A)
// 执行条件判断 foo('B')
// 执行循环体  foo('D')
//第二次循环  执行步长值表达式  foo('C')
//执行条件判断 foo('B')
//执行 循环体  foo('D')
//第三次循环  执行步长值  foo('C')
//执行 条件判断 foo('B')  然后退出












































//ABDCBDCB

/*
What is the result?
A. ABDCBDCB
B. ABCDABCD
C. Compilation fails.
D. An exception is thrown at runtime.
//输出结果是：ABDCBDCB
分析：FOR循环里面讲究的条件要为真，与你的判断式是什么没有关系
就像这里，虽然是打印的字母，但是却不是false，所以可以执行
第一次进行循环：
foo('A')打印字母A，（注：这里不是false条件就默认为true条件）
foo('B')打印字母B，i=0,比较(i < 2)，条件为true，进行循环体，foo('D')打印D
foo('C')打印字母C
第二次循环：
foo('B')打印B，i=1,比较(i < 2)为true，进行循环体，foo('D')打印D
foo('C')打印字母C
第三次循环：
foo('B')打印字母B，i=2，比较(i < 2)为false，退出循环，得结果
*/
