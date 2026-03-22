package com.lhosdp;

public class Daxiaoxie {

    public static void main(String[] args) {
        //将输入的大写字符串转换为小写 并输出
        String str = "SYS_DEPT_NEW";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            System.out.print(c);
        }
    }
}
