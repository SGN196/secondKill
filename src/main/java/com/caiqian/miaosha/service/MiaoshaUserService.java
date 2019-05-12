package com.caiqian.miaosha.service;

import com.caiqian.miaosha.dao.MiaoshaUserMapper;
import com.caiqian.miaosha.domain.MiaoshaUser;
import com.caiqian.miaosha.exception.GlobleException;
import com.caiqian.miaosha.redis.MiaoshaUserKey;
import com.caiqian.miaosha.redis.RedisService;
import com.caiqian.miaosha.result.CodeMsg;
import com.caiqian.miaosha.util.MD5Util;
import com.caiqian.miaosha.util.UUIDUtil;
import com.caiqian.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SGN196
 * @date 2019/3/26 19:53
 */

@Service
public class MiaoshaUserService
{
    public  static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserMapper miaoshaUserMapper;

    @Autowired
    RedisService redisService;

    public MiaoshaUser getById(long id){
        return miaoshaUserMapper.getById(id);
    }

    public boolean login(HttpServletResponse httpServletResponse, LoginVo loginVo)
    {
        if(loginVo == null){
            throw new GlobleException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        MiaoshaUser miaoshaUser = getById(Long.parseLong(mobile));
        if(miaoshaUser == null){
            throw new GlobleException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPass = miaoshaUser.getPassword();
        String saltDB = miaoshaUser.getSalt();
        String calcPass = MD5Util.formPassDBPass(formPass, saltDB);
        if(!dbPass.equals(calcPass)){
            throw new GlobleException(CodeMsg.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        redisService.set(MiaoshaUserKey.token, token, miaoshaUser);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        return true;
    }

    public MiaoshaUser getByToken(String token)
    {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        return redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
    }

//    private void addCookie(HttpServletResponse response, MiaoshaUser user){
//        String token = UUIDUtil.uuid();
//        redisService.set(MiaoshaUserKey.token, token, user);
//        Cookie cookie = new Cookie()
//    }
}
