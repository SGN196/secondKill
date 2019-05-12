package com.caiqian.miaosha.exception;

import com.caiqian.miaosha.result.CodeMsg;
import com.caiqian.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author SGN196
 * @date 2019/4/3 20:51
 */


@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler
{

    @ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){

        if(e instanceof GlobleException){
            GlobleException ex = (GlobleException)e;
            return Result.error(ex.getCodeMsg());
        }else if(e instanceof BindException){
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }



}
