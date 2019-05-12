package com.caiqian.miaosha.exception;

import com.caiqian.miaosha.result.CodeMsg;

/**
 * @author SGN196
 * @date 2019/4/3 23:05
 */

public class GlobleException extends RuntimeException
{
    private static final  long serialVersionUID = 1L;
    private CodeMsg codeMsg;
    public GlobleException(CodeMsg cm){
        super(cm.toString());
        codeMsg = cm;
    }
    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
