package com.caiqian.miaosha.redis;

/**
 * @author SGN196
 * @date 2019/3/24 15:37
 */

public interface KeyPrefix
{
    public int expireSeconds();
    public String getPrifix();
}
