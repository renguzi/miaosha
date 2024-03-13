package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

/**
 * @Author:asher
 * @Date:3/4/24 17:17
 * @Description:com.miaoshaproject.service.impl
 * @Version:1.0
 */
public interface ItemService {

    //    创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //    商品浏览
    List<ItemModel> listItem();

    //    商品详情浏览
    ItemModel getItemById(Integer id);

    //    减库存
    boolean decreaseStock(Integer itemId,Integer amount) throws BusinessException;

    //    商品销量增加
    void increaseSales(Integer itemId, Integer amount);

}
