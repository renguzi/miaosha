package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dao.UserPasswordDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.dataobject.UserPasswordDO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessErr;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:asher
 * @Date:7/5/23 17:04
 * @Description:com.miaoshaproject.service.impl
 * @Version:1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用userdomapper获取到对应的用户dataobject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        //如果用户为空，直接返回null
        if (userDO == null) {
            return null;
        }
        //通过用户id获取到用户加密的密码信息
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());

        //通过userDo和userPasswordDo，拼装成1个userModel
        return this.convertFromDataObject(userDO, userPasswordDO);
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessErr.PARAMETER_VALIDATAION_ERROR);
        }
        if (StringUtils.isEmpty(userModel.getName())
                || userModel.getAge() == null
                || userModel.getGender() == null
                || StringUtils.isEmpty(userModel.getTelphone())) {
            throw new BusinessException(EmBusinessErr.PARAMETER_VALIDATAION_ERROR);
        }
        UserDO userDO = new UserDO();
//        实现model-->dataobject的方法
        userDO = convertFromModel(userModel);
        userDOMapper.insertSelective(userDO);

        //不加下面的行,会导致密码表的user_id和用户表的id不匹配,且密码表的user_id一直是0
        userModel.setId(userDO.getId());
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO = convertPasswordFromModel(userModel);
        userPasswordDOMapper.insertSelective(userPasswordDO);

    }

    private UserPasswordDO convertPasswordFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncryptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }
    private UserDO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncryptPassword());
        }
        return userModel;
    }
}
