package com.caiqian.miaosha.controller;

import com.caiqian.miaosha.bean.User;
import com.caiqian.miaosha.domain.MiaoshaUser;
import com.caiqian.miaosha.redis.RedisService;
import com.caiqian.miaosha.service.MiaoshaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

/**
 * @author SGN196
 * @date 2019/4/4 8:41
 */

@Controller
@RequestMapping("/goods")
public class Goodscontroller
{
    private static Logger log = LoggerFactory.getLogger(Goodscontroller.class);

    @Autowired
    RedisService redisService;

    @Autowired
    MiaoshaUserService userService;

    @ResponseBody
    @RequestMapping("/cal")
    public String cal(@RequestBody User user){
        String xxx = user.toString();
        System.out.println(xxx);
        return xxx;
    }

    @RequestMapping("/to_list")
    public String toLogin(Model model, @CookieValue(value=MiaoshaUserService.COOKI_NAME_TOKEN, required = false)
            String cookieToken, @RequestParam(value=MiaoshaUserService.COOKI_NAME_TOKEN) String paramToken){


        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
            return "login";
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        MiaoshaUser user = userService.getByToken(token);

        model.addAttribute("user", new MiaoshaUser());


        return "goods_list";
    }

    @RequestMapping("/totest")
    public String toTest(){
        return "test";
    }
}
