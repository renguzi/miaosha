package com.miaoshaproject.service;

import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

/**
 * @Author:asher
 * @Date:7/5/23 17:04
 * @Description:com.miaoshaproject.service
 * @Version:1.0
 */
public interface UserService {
   //通过id获取用户对象的方法
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
}
