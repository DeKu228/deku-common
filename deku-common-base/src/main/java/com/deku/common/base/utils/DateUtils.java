package com.deku.common.base.utils;

import lombok.NonNull;

import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: deku
 * @Date: 2019/11/2
 */
public class DateUtils {

    /**
     * 获取当前日期
     *
     * @return current date
     */
    @NonNull
    public static Date now() {
        return new Date();
    }
}
