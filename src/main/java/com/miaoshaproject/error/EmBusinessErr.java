package com.miaoshaproject.error;

/**
 * @Author:asher
 * @Date:7/13/23 08:57
 * @Description:com.miaoshaproject.error
 * @Version:1.0
 */
public enum EmBusinessErr implements CommonError {
//    10001通用错误类型
    PARAMETER_VALIDATAION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),

    //20000开头的为用户信息相关定义
    USER_NOT_EXIST(20001,"用户不存在") ,
    USER_LOGIN_FAILD(20002, "用户手机号或密码不准确");

    private int errCode;
    private String errMsg;

    EmBusinessErr(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg=errMsg;
        return this;
    }
}
