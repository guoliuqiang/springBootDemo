package com.lhosdp.demo.codestatistic;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.lhosdp.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TimeBetween {

    public static void main(String[] args) {

        int x = 10;

        do{
            System.out.print("value of x : " + x );
            x++;
            System.out.print("\n");
        }while( x < 10 );

    }

//    default long getPages() {
//        if (getSize() == 0) {
//            return 0L;
//        }
//        long pages = getTotal() / getSize();
//        if (getTotal() % getSize() != 0) {
//            pages++;
//        }
//        return pages;
//    }



}
