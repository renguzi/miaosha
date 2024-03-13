package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * @Author:asher
 * @Date:3/7/24 17:18
 * @Description:com.miaoshaproject.service
 * @Version:1.0
 */
public interface OrderService {

    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;


}
