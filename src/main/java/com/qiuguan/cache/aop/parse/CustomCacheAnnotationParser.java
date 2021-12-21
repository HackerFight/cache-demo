package com.qiuguan.cache.aop.parse;


import com.qiuguan.cache.ann.CustomCacheable;
import org.springframework.cache.annotation.CacheAnnotationParser;
import org.springframework.cache.interceptor.CacheOperation;
import org.springframework.core.annotation.AnnotationUtils;
import sun.reflect.annotation.AnnotationParser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author created by qiuguan on 2021/12/21 17:28
 */
public class CustomCacheAnnotationParser implements CacheAnnotationParser {

    private static final Set<Class<? extends Annotation>> CACHE_OPERATION_ANNOTATIONS = new LinkedHashSet<>(8);

    static {
        CACHE_OPERATION_ANNOTATIONS.add(CustomCacheable.class);
    }

    /**
     * 是否为候选的类
     * @param clazz
     * @return
     */
    @Override
    public boolean isCandidateClass(Class<?> clazz) {
        return AnnotationUtils.isCandidateClass(clazz, CACHE_OPERATION_ANNOTATIONS);
    }

    @Override
    public Collection<CacheOperation> parseCacheAnnotations(Class<?> type) {
        return null;
    }

    @Override
    public Collection<CacheOperation> parseCacheAnnotations(Method method) {
        return null;
    }
}
