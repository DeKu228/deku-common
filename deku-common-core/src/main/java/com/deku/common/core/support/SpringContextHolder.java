package com.deku.common.core.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Bean Tool
 *
 * @Author: deku
 * @Date: 2019/1/24
 */
@Component
@Slf4j
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextHolder.applicationContext == null) {
            SpringContextHolder.applicationContext = applicationContext;
        }
        log.info("Starting Initialization ApplicationContext Object Successfully.");
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /** 通过Bean Name获取对象 **/
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertApplicationContext();
        return (T) getApplicationContext().getBean(name);
    }

    /** 通过类型获取对象 **/
    public static <T> T getBean(Class<T> clz) {
        assertApplicationContext();
        return (T) getApplicationContext().getBean(clz);
    }

    /** 通过名称&类型获取对象 **/
    public static <T> T getBean(String name, Class<T> clz) {
        assertApplicationContext();
        return (T) getApplicationContext().getBean(name, clz);
    }

    private static void assertApplicationContext() {
        if (SpringContextHolder.applicationContext == null) {
            throw new IllegalArgumentException("applicationContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }
}
