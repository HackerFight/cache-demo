package com.qiuguan.cache.service;

import com.qiuguan.cache.ann.CustomCacheable;
import com.qiuguan.cache.bean.UserInfo;
import com.qiuguan.cache.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author created by qiuguan on 2021/12/21 15:54
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    //@Cacheable(cacheNames = "userInfo")
    @CustomCacheable(cacheNames = "userInfo")
    public UserInfo getUserInfo(Long id){
        return this.userInfoMapper.getUserInfo(id);
    }

    public UserInfo getUserInfo2(Long id){
        return this.userInfoMapper.getUserInfo(id);
    }
}
