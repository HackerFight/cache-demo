package com.qiuguan.cache.aop.filter;

import com.qiuguan.cache.aop.interceptor.CacheOperationSource;
import org.springframework.aop.ClassFilter;
import org.springframework.cache.CacheManager;

/**
 * @author created by qiuguan on 2021/12/21 14:54
 */
public class CustomCacheOperationSourceClassFilter implements ClassFilter {

    private final CacheOperationSource cacheOperationSource;

    public CustomCacheOperationSourceClassFilter(CacheOperationSource cacheOperationSource) {
        this.cacheOperationSource = cacheOperationSource;
    }

    /**
     * 优先过滤类
     * @param clazz
     * @return
     */
    @Override
    public boolean matches(Class<?> clazz) {
        if (CacheManager.class.isAssignableFrom(clazz)) {
            return false;
        }

        CacheOperationSource source = cacheOperationSource;
        return source.isCandidateClass(clazz);
    }
}
