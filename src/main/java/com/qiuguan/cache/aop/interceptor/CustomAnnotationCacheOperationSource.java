package com.qiuguan.cache.aop.interceptor;


import com.qiuguan.cache.aop.parse.CustomCacheAnnotationParser;
import org.springframework.cache.annotation.CacheAnnotationParser;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author created by qiuguan on 2021/12/21 17:18
 */
public class CustomAnnotationCacheOperationSource implements CacheOperationSource {

    private final boolean publicMethodsOnly;

    private final Set<CacheAnnotationParser> annotationParsers;

    public CustomAnnotationCacheOperationSource() {
        this(true);
    }

    public CustomAnnotationCacheOperationSource(boolean publicMethodsOnly) {
        this.publicMethodsOnly = publicMethodsOnly;
        this.annotationParsers = Collections.singleton(new CustomCacheAnnotationParser());
    }

    @Override
    public boolean isCandidateClass(Class<?> targetClass) {
        for (CacheAnnotationParser annotationParser : this.annotationParsers) {
            if (annotationParser.isCandidateClass(targetClass)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Collection<CacheOperation> getCacheOperations(Method method, Class<?> targetClass) {
        return null;
    }
}
