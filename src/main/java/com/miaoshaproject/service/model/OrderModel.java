package com.miaoshaproject.service.model;

import java.math.BigDecimal;

/**
 * @Author:asher
 * @Date:3/7/24 16:55
 * @Description:com.miaoshaproject.service.model
 * @Version:1.0
 */
//用户下单的交易模型
public class OrderModel {
    private String id;

    private Integer userId;

    private Integer itemId;

    private BigDecimal itemPrice;

    private Integer amount;

    private BigDecimal amountPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(BigDecimal amountPrice) {
        this.amountPrice = amountPrice;
    }
}
