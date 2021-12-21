package com.qiuguan.cache.aop;

import com.qiuguan.cache.aop.interceptor.CacheOperationSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author created by qiuguan on 2021/12/21 14:42
 * @see SmartInitializingSingleton 在所有的单实例bean 创建完成后才会去触发
 *
 * @see org.springframework.beans.factory.config.ConfigurableListableBeanFactory#preInstantiateSingletons()
 */
public abstract class AbstractCacheInterceptorSupport implements BeanFactoryAware, InitializingBean, SmartInitializingSingleton {

    protected final Log logger = LogFactory.getLog(getClass());

    private BeanFactory beanFactory;

    private CacheOperationSource cacheOperationSource;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void afterSingletonsInstantiated() {

    }

    public CacheOperationSource getCacheOperationSource() {
        return cacheOperationSource;
    }

    public void setCacheOperationSource(CacheOperationSource cacheOperationSource) {
        this.cacheOperationSource = cacheOperationSource;
    }
}
