package com.lhosdp.demo.codestatistic;

import static com.alibaba.fastjson.JSONPatch.OperationType.replace;

public class Testreplace {

    public static void main(String[] args) {
        String xml = "InclusiveGatewaywwwwwwwwwwwwww";
        String replacexml = xml.replace("InclusiveGateway", "eventBasedGateway");
        System.out.println(replacexml);

        Long aaa = 0L;
        if(aaa >= 0 && aaa <= 100) {
            System.out.println("通过");
        }else{
            System.out.println("通过");
        }
    }
}
