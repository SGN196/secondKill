package com.caiqian.miaosha.redis;

import com.caiqian.miaosha.domain.User;

/**
 * @author SGN196
 * @date 2019/3/24 15:42
 */

public class UserKey extends BasePrefix
{
    public UserKey(String prefix)
    {
        super( prefix);
    }
    public UserKey(int exprieSeconds, String prefix)
    {
        super(exprieSeconds, prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
    public static UserKey test01 = new UserKey(20, "test");
}
