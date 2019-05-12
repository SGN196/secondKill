package com.caiqian.miaosha.validator;

import com.caiqian.miaosha.util.ValidatorUtil;
import org.springframework.boot.autoconfigure.validation.ValidatorAdapter;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author SGN196
 * @date 2019/3/26 21:05
 */

public class IsMobileValidator implements ConstraintValidator<IsMobile, String>
{
    private boolean required =false;


    @Override
    public void initialize(IsMobile constraintAnnotation)
    {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext)
    {
        if(required){
            return ValidatorUtil.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isMobile(value);
            }
        }

    }

}
