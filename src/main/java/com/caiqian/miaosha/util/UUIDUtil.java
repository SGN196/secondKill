package com.caiqian.miaosha.util;

import java.util.UUID;

/**
 * @author SGN196
 * @date 2019/4/4 7:59
 */

public class UUIDUtil
{
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
