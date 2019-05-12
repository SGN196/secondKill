package com.caiqian.miaosha.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SGN196
 * @date 2019/3/26 13:37
 */

public class ValidatorUtil
{
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src){
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();    //尝试与整个区域模式匹配，返回Boolean
    }

//    public static void main(String[] args)
//    {
//        System.out.println(isMobile("13812341234"));
//        System.out.println(isMobile("1381234134"));
//    }
}
