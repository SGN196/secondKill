package com.caiqian.miaosha.redis;

/**
 * @author SGN196
 * @date 2019/3/24 15:42
 */

public class OrderKey extends BasePrefix
{
    public OrderKey(int exprieSeconds, String prefix)
    {
        super(exprieSeconds, prefix);
    }
}
