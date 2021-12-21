package com.qiuguan.cache;

import com.qiuguan.cache.ann.CustomCacheable;
import com.qiuguan.cache.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author created by qiuguan on 2021/12/21 10:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test(){
        userInfoService.getUserInfo(11L);
    }

    @Test
    public void test2(){
        boolean candidateClass = AnnotationUtils.isCandidateClass(UserInfoService.class, CustomCacheable.class);
        System.out.println(candidateClass);
    }
}
