package com.qiuguan.cache.imports;

import com.qiuguan.cache.config.CustomProxyCachingConfiguration;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by qiuguan on 2021/12/21 11:20
 */
public class CustomCachingConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> list = new ArrayList<>(2);
        /**
         * @see AutoProxyRegistrar
         * 这个类注册了事务，AspectJ 需要的处理器
         * 缓存也是一样的，和 事务一样
         */
        list.add(AutoProxyRegistrar.class.getName());

        list.add(CustomProxyCachingConfiguration.class.getName());

        return StringUtils.toStringArray(list);
    }
}
