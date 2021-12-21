package com.qiuguan.cache.aop;

import com.qiuguan.cache.ann.CustomCacheable;
import com.qiuguan.cache.aop.filter.CustomCacheOperationSourceClassFilter;
import com.qiuguan.cache.aop.interceptor.CacheOperationSource;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;

/**
 * @author created by qiuguan on 2021/12/21 14:52
 */
public class CustomCachingSourcesPointcut extends StaticMethodMatcherPointcut {

    public CustomCachingSourcesPointcut(CacheOperationSource cacheOperationSource){
        setClassFilter(new CustomCacheOperationSourceClassFilter(cacheOperationSource));
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return AnnotatedElementUtils.hasAnnotation(method, CustomCacheable.class);
    }
}
