package com.caiqian.miaosha.controller;

import com.caiqian.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SGN196
 * @date 2019/3/24 23:05
 */
@RequestMapping("/login")
@Controller
public class LoginController
{

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public String doLogin(LoginVo loginVo){
        log.info(loginVo.toString());
        return "hello";
    }


}
