package com.caiqian.miaosha.controller;

import com.caiqian.miaosha.domain.User;
import com.caiqian.miaosha.redis.RedisService;
import com.caiqian.miaosha.redis.UserKey;
import com.caiqian.miaosha.result.Result;
import com.caiqian.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SGN196
 * @date 2019/3/23 18:35
 */

@Controller
@RequestMapping("/demo")
public class SampleController
{

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;


    @RequestMapping("hhaa")
    @ResponseBody
    public Result<String> hhaa(){
        return Result.success("hello world");
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","Joshua");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public String  dbGet(){

        User user = userService.getById(1);
        return user.toString();
    }


    @RequestMapping("/db/tx")
    @ResponseBody
    public String  dbTx(){

        userService.tx();
        return "";
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public String redisGet(){

        User user = redisService.get(UserKey.getByName, "" + 1, User.class);

        return user.toString();
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public String redisSet(){
        User user = new User(4, "Tom");
        Boolean flag = redisService.set(UserKey.test01,"" + 4, user);
        return flag.toString();
    }



    @RequestMapping("/redis/exists")
    @ResponseBody
    public String redisExists(){
        Boolean flag = redisService.exists(UserKey.test01,"" + 4);
        return flag.toString();
    }







}
