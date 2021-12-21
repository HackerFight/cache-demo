package com.qiuguan.cache.ann;

import com.qiuguan.cache.imports.CustomCachingConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author created by qiuguan on 2021/12/21 11:25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomCachingConfigurationSelector.class)
public @interface EnableCustomCaching {

}
