package com.caiqian.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author SGN196
 * @date 2019/3/24 11:33
 */

@Service
public class RedisService
{

    @Autowired
    JedisPool jedisPool;



    public <T> boolean set(KeyPrefix keyprefix, String key, T value)
    {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if(str == null || str.length() == 0){
                return false;
            }
            String realKey = keyprefix.getPrifix() + key;
            int seconds = keyprefix.expireSeconds();
            if(seconds <= 0)
            {
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey, seconds, str);
            }
            return true;
        }finally
        {
            returnToPool(jedis);
        }
    }


    public <T> T get(KeyPrefix keyprefix, String key, Class<T> clazz){

        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyprefix.getPrifix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        }finally
        {
            returnToPool(jedis);
        }
    }

    public <T> boolean exists(KeyPrefix keyprefix, String key){

        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyprefix.getPrifix() + key;
            return jedis.exists(realKey);
        }finally
        {
            returnToPool(jedis);
        }
    }

    //增加值
    public <T> Long incr(KeyPrefix keyprefix, String key){

        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyprefix.getPrifix() + key;
            return jedis.incr(realKey);
        }finally
        {
            returnToPool(jedis);
        }
    }

    //减少值
    public <T> Long decr(KeyPrefix keyprefix, String key){

        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyprefix.getPrifix() + key;
            return jedis.decr(realKey);
        }finally
        {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value)
    {
        if(value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return "" +value;
        }else if(clazz == String.class){
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class){
            return "" + value;
        }else{
            return JSON.toJSONString(value);
        }
    }
    private <T> T stringToBean(String str, Class<T> clazz)
    {
        if(clazz == null || str == null || str.length() <= 0){
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


    private void returnToPool(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }


}
