package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.ItemVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:asher
 * @Date:3/5/24 11:55
 * @Description:com.miaoshaproject.controller
 * @Version:1.0
 */
@Controller("/item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true",origins = {"*"})
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/create", method = {RequestMethod.POST}, consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonReturnType createItem(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") BigDecimal price,
            @RequestParam(name = "stock") Integer stock,
            @RequestParam(name = "imgUrl") String imgUrl
    ) throws BusinessException {

//        封装service请求来创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setStock(stock);
        itemModel.setPrice(price);
        itemModel.setImgUrl(imgUrl);
        itemModel.setDescription(description);

        ItemModel itemModelForReturn = itemService.createItem(itemModel);
        ItemVO itemVO = new ItemVO();
        itemVO = this.convertVOFromModel(itemModelForReturn);
        return CommonReturnType.create(itemVO);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET )
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id") Integer id) {
        ItemModel itemModel = itemService.getItemById(id);
        ItemVO itemVO = convertVOFromModel(itemModel);
        return CommonReturnType.create(itemVO);
    }

    //    商品列表页面浏览
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType listItem() {
        List<ItemModel> itemModelList = itemService.listItem();
        List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = this.convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVOList);
    }

    private ItemVO convertVOFromModel(ItemModel itemModel) {

        if (itemModel == null) {
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        return itemVO;
    }

}
