package com.qiuguan.cache.controller;

import com.qiuguan.cache.bean.UserInfo;
import com.qiuguan.cache.mapper.UserInfoMapper;
import com.qiuguan.cache.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by qiuguan on 2021/12/21 11:03
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("get/{id}")
    public String getUser(@PathVariable Long id){
        UserInfo userInfo = this.userInfoService.getUserInfo(id);
        logger.info("userId: {} --- userData: {}", id, userInfo);

        return userInfo.toString();
    }
}
