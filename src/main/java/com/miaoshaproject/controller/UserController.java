package com.miaoshaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:asher
 * @Date:7/5/23 17:00
 * @Description:com.miaoshaproject.controller
 * @Version:1.0
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get")
    public void getUser(@RequestParam(name = "id") Integer id) {
        //调用service服务获取id对应的用户对象并返回给前端
    }


}
