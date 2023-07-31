package com.miaoshaproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessErr;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @Author:asher
 * @Date:7/5/23 17:00
 * @Description:com.miaoshaproject.controller
 * @Version:1.0
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode")String otpCode,
                                     @RequestParam(name = "name")String name,
                                     @RequestParam(name = "password")String password,
                                     @RequestParam(name = "age")Integer age,
                                     @RequestParam(name="gender")Integer gender) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
//        验证手机号和对应的otpcode相符合

        String inSessionOtpCode= (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals( otpCode,inSessionOtpCode)) {
            throw new BusinessException(EmBusinessErr.PARAMETER_VALIDATAION_ERROR,"短信验证码不符合");
        }

//        进入用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setEncrptPassword(this.EncodeByMd5(password));
        userModel.setResisterMode("byphone");
        userService.register(userModel);
        return CommonReturnType.create(null);

    }

    public String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

//    用户获取otp短信接口
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody

    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {

//        1按照一定的规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);
//        2将otp验证码与用户手机号关联,使用httpsession的方式绑定手机号和otp
        httpServletRequest.getSession().setAttribute(telphone, otpCode);

//        3将otp验证码发送给用户
        System.out.println("telnphone = " + telphone + "otpcode +" + otpCode);
        return CommonReturnType.create(null);

    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务获取id对应的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        if (userModel == null) {
            throw new BusinessException(EmBusinessErr.USER_NOT_EXIST);
        }

        //将核心领域模型userVO转换为供UI使用的viewobject
        UserVO userVO = convertFromUserModel(userModel);
//        返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromUserModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}
