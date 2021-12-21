package com.qiuguan.cache.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author created by qiuguan on 2021/12/21 14:37
 */
public class CustomCacheInterceptor extends AbstractCacheInterceptorSupport implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println(".........");
        return null;
    }
}
