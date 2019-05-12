package com.caiqian.miaosha.controller;

import com.caiqian.miaosha.result.CodeMsg;
import com.caiqian.miaosha.result.Result;
import com.caiqian.miaosha.service.MiaoshaUserService;
import com.caiqian.miaosha.util.ValidatorUtil;
import com.caiqian.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

/**
 * @author SGN196
 * @date 2019/3/24 23:05
 */
@RequestMapping("/login")
@Controller
public class LoginController
{

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/do_login")
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){
        log.info(loginVo.toString());

        if(miaoshaUserService.login(response, loginVo)){
            return Result.success(true);
        }
        return Result.error(CodeMsg.SERVER_ERROR);

    }


}
