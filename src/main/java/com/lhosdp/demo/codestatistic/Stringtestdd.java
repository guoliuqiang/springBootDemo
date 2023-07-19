package com.lhosdp.demo.codestatistic;

import com.lhosdp.demo.testRight.SmartLifeUtil;
import jodd.util.Base64;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Stringtestdd {

    static private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws ParseException {
        final Boolean timeDiff = getTimeDiff(dateFormat.parse("2023-04-24 13:35:24"), dateFormat.parse("2023-04-24 13:35:24"));
        System.out.println(timeDiff);
    }


    public static Boolean getTimeDiff(Date startTime, Date endTime) {
        final String start = dateFormat.format(startTime).split(" ")[0];
        final String end = dateFormat.format(endTime).split(" ")[0];
        if(startTime.equals(endTime)){
            return true;
        }else{
            return false;
        }
    }





}
