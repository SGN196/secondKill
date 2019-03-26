package com.caiqian.miaosha.redis;

/**
 * @author SGN196
 * @date 2019/3/24 15:38
 */

public abstract class BasePrefix implements KeyPrefix
{
    private int exprieSeconds;

    private String prefix;

    public BasePrefix(String prefix){
        this(0, prefix);
    }

    public BasePrefix(int exprieSeconds, String prefix)
    {
        this.exprieSeconds = exprieSeconds;
        this.prefix = prefix;
    }

    // 默认0：代表永不过期
    @Override
    public int expireSeconds()
    {
        return exprieSeconds;
    }

    @Override
    public String getPrifix()
    {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
