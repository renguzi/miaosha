package com.miaoshaproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * @Author:asher
 * @Date:3/13/24 14:22
 * @Description:com.miaoshaproject.service.model
 * @Version:1.0
 */
public class PromModel {
//    活动id
    private Integer id;
//    活动名称
    private String promName;

    //    活动开始时间
    private DateTime startDate;
//    秒杀活动适用商品
    private Integer itemId;

    //秒杀商品价格
    private BigDecimal promItemPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromName() {
        return promName;
    }

    public void setPromName(String promName) {
        this.promName = promName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromItemPrice() {
        return promItemPrice;
    }

    public void setPromItemPrice(BigDecimal promItemPrice) {
        this.promItemPrice = promItemPrice;
    }
}
