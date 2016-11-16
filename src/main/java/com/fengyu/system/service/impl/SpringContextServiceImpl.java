package com.fengyu.system.service.impl;

import com.fengyu.system.service.SpringContextService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * spring 上下文配置
 * Created by rain on 2016/11/16.
 */
@Service
public class SpringContextServiceImpl implements SpringContextService {
    private static Logger logger = Logger.getLogger(SpringContextServiceImpl.class);

    /* 1.沿用springTest的这种方法 是否会更好？
    *  2.get/set方式*/
    @Autowired
    ApplicationContext applicationContext;
/*
    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("------SpringContextUtil setApplicationContext-------");
        SpringContextServiceImpl.applicationContext = applicationContext;
    }

    //注意此处变成了static
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }*/

    /**
     * 注意 bean name默认 = 类名(首字母小写)
     * 例如: A8sClusterDao = getBean("k8sClusterDao")
     * @param name
     * @return
     * @throws BeansException
     */
    public Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 根据类名获取到bean
     * @param <T>
     * @param clazz
     * @return
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public <T> T getBeanByName(Class<T> clazz) throws BeansException {
        try {
            char[] cs=clazz.getSimpleName().toCharArray();
            cs[0] += 32;//首字母大写到小写
            return (T) applicationContext.getBean(String.valueOf(cs));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }
}
