package com.caiqian.miaosha.redis;

/**
 * @author SGN196
 * @date 2019/4/4 8:03
 */

public class MiaoshaUserKey extends BasePrefix
{
   public static final int TOKEN_EXPIRE = 3600*24 * 2;

   private MiaoshaUserKey(int expireSeconds, String prefix){
       super(expireSeconds, prefix);
   }
   public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"tk");
}
