package com.qiuguan.cache.aop;

import com.qiuguan.cache.aop.interceptor.CacheOperationSource;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
/**
 * @author created by qiuguan on 2021/12/21 14:17
 */
public class CustomBeanFactoryCacheOperationSourceAdvisor extends AbstractPointcutAdvisor {

    private Pointcut pointcut;

    private Advice advice;

    private CacheOperationSource cacheOperationSource;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    public CacheOperationSource getCacheOperationSource() {
        return cacheOperationSource;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setCacheOperationSource(CacheOperationSource cacheOperationSource) {
        this.cacheOperationSource = cacheOperationSource;
    }
}
