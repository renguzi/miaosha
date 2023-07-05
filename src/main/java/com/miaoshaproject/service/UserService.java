package com.miaoshaproject.service;

import com.miaoshaproject.dataobject.UserDO;

/**
 * @Author:asher
 * @Date:7/5/23 17:04
 * @Description:com.miaoshaproject.service
 * @Version:1.0
 */
public interface UserService {
   //通过id获取用户对象的方法
    void getUserById(Integer id);
}
