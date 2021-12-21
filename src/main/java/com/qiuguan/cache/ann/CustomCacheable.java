package com.qiuguan.cache.ann;

import java.lang.annotation.*;

/**
 * @author created by qiuguan on 2021/12/21 16:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomCacheable {

    String[] cacheNames() default {};
}
