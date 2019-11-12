package com.deku.common.core.annotation;

import com.deku.common.core.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @Author: deku
 * @Date: 2018/11/20
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /** 模块名 **/
    String title() default "";
    /** 日志类型（默认：操作日志类型） **/
    LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;
    /** 是否保存请求参数 **/
    boolean isSaveRequestData() default true;
    /** 是否响应结果 **/
    boolean isSaveResponseData() default true;
}
