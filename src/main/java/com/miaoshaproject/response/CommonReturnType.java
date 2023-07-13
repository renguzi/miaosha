package com.miaoshaproject.response;

/**
 * @Author:asher
 * @Date:7/12/23 16:53
 * @Description:com.miaoshaproject.response
 * @Version:1.0
 */
public class CommonReturnType {

//   表示对应请求的返回结果:success或fail
    private String status;

//    status=success,则data内返回前端需要的JSON数据
//    status=fail,则data内使用通用的错误码格式
    private Object data;


    //    定义一个通用的创建方法
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
