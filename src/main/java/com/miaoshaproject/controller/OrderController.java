package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessErr;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.OrderService;
import com.miaoshaproject.service.model.OrderModel;
import com.miaoshaproject.service.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:asher
 * @Date:3/11/24 17:14
 * @Description:com.miaoshaproject.controller
 * @Version:1.0
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true",origins = {"*"})
public class OrderController extends BaseController {

     @Autowired
     private OrderService orderService;

     @Autowired
     private HttpServletRequest httpServletRequest;


     @RequestMapping(value = "/createorder", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
     @ResponseBody
     public CommonReturnType createOrder(@RequestParam(name="itemId") Integer itemId, @RequestParam(name="amount") Integer amount) throws BusinessException {
          Boolean is_login = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");
          if (is_login == null || !is_login.booleanValue()) {
               throw new BusinessException(EmBusinessErr.USER_NOT_LOGIN, "用户未登录，不能下单");
          }
//          获取用户登录信息
          UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");


          OrderModel orderModel = orderService.createOrder(userModel.getId(), itemId, amount);


          return CommonReturnType.create(null);
     }
}
