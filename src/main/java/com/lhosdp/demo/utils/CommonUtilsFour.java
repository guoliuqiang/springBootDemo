package com.lhosdp.demo.utils;


import java.util.ArrayList;

public class CommonUtilsFour {

    public static void main(String[] args) {
        String keyone = "jfaosdjfos{mykey}";
        String keyone1 = "jfaosdjfodddds{mykey}";
        String keyone2 = "jfaosdjfosadfasdfasds{mykey}";

        int i = keyone1.indexOf("{mykey}");
        String substring = keyone1.substring(0, i);
        System.out.println(substring);

        System.out.println(496/2);
    }





}
