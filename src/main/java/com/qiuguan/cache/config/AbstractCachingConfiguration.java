package com.qiuguan.cache.config;

import com.qiuguan.cache.ann.EnableCustomCaching;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author created by qiuguan on 2021/12/21 14:23
 *
 * 实现了 ImportAware 接口，会注入注解信息
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor.ImportAwareBeanPostProcessor
 */
public abstract class AbstractCachingConfiguration implements ImportAware {

    protected AnnotationAttributes enableCustomCaching;

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.enableCustomCaching =
                AnnotationAttributes.fromMap(importMetadata.getAnnotationAttributes(EnableCustomCaching.class.getName(), false));

        if (this.enableCustomCaching == null) {
            throw new IllegalArgumentException("@EnableCustomCaching is not present on importing class " + importMetadata.getClassName());
        }
    }
}
