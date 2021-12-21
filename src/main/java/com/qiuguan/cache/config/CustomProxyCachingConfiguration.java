package com.qiuguan.cache.config;

import com.qiuguan.cache.aop.CustomBeanFactoryCacheOperationSourceAdvisor;
import com.qiuguan.cache.aop.CustomCacheInterceptor;
import com.qiuguan.cache.aop.CustomCachingSourcesPointcut;
import com.qiuguan.cache.aop.interceptor.CacheOperationSource;
import com.qiuguan.cache.aop.interceptor.CustomAnnotationCacheOperationSource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * @author created by qiuguan on 2021/12/21 11:21
 */
//@Configuration
public class CustomProxyCachingConfiguration extends AbstractCachingConfiguration {

    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Bean(name = "com.qiuguan.spring.cache.customAdvisor")
    public CustomBeanFactoryCacheOperationSourceAdvisor advisor(){
        CustomBeanFactoryCacheOperationSourceAdvisor advisor = new CustomBeanFactoryCacheOperationSourceAdvisor();
        advisor.setAdvice(customCacheInterceptor());
        advisor.setCacheOperationSource(cacheOperationSource());
        advisor.setPointcut(new CustomCachingSourcesPointcut(cacheOperationSource()));
        return advisor;
    }

    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Bean(name = "com.qiuguan.spring.cache.customCacheOperationSource")
    public CacheOperationSource cacheOperationSource(){
        return new CustomAnnotationCacheOperationSource();
    }


    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Bean(name = "com.qiuguan.spring.cache.customCacheInterceptor")
    public CustomCacheInterceptor customCacheInterceptor(){
        CustomCacheInterceptor customCacheInterceptor = new CustomCacheInterceptor();
        customCacheInterceptor.setCacheOperationSource(cacheOperationSource());
        return customCacheInterceptor;
    }
}
