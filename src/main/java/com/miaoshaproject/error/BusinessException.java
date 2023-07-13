package com.miaoshaproject.error;

/**
 * @Author:asher
 * @Date:7/13/23 10:42
 * @Description:com.miaoshaproject.error
 * @Version:1.0
 */
public class BusinessException extends Exception implements CommonError {

//    强关联的CommonError，其实就是EmBusinessErr这个枚举类
    private CommonError commonError;
//    直接接收EmBusinessError的传参，用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

//    接收自定义errMsg的方式，构造业务异常
    public BusinessException(CommonError commonError,String message) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(message);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
