package com.caiqian.miaosha.result;

/**
 * @author SGN196
 * @date 2019/3/26 12:56
 */

public  class Result<T>
{
    private int code;   // 错误码
    private String msg;  //错误信息
    private T data;   // 成功时的信息

    private Result(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(){

    }
    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<>(codeMsg);

    }

    private Result(CodeMsg codeMsg){
        if(codeMsg == null){
            return ;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
