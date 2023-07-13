package com.miaoshaproject.error;

/**
 * @Author:asher
 * @Date:7/13/23 08:53
 * @Description:com.miaoshaproject.error
 * @Version:1.0
 */
public interface CommonError {
    public int getErrorCode();

    public String getErrorMsg();

    public CommonError setErrMsg(String errMsg);
}
