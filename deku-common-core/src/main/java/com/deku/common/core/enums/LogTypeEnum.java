package com.deku.common.core.enums;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: deku
 * @Date: 2019/1/21
 */
public enum LogTypeEnum {
    /** 操作日志 **/
    OPERATION_LOG("OPERATION_LOG", "操作日志"),
    /** 登录日志 **/
    LOGIN_LOG("LOGIN_LOG", "登录日志"),
    /** 异常日志 **/
    EXCEPTION_LOG("EXCEPTION_LOG", "异常日志");

    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    LogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 根据类型获取名称
     * @param type
     * @return
     */
    public static String getName(String type) {
        for (LogTypeEnum logTypeEnum : LogTypeEnum.values()) {
            if (type.equals(logTypeEnum.getType())) {
                return logTypeEnum.getName();
            }
        }
        return null;
    }

    /**
     * 根据类型获取Enum对象
     * @param type
     * @return
     */
    public static LogTypeEnum getEnum(String type) {
        for (LogTypeEnum logTypeEnum : LogTypeEnum.values()) {
            if (type.equals(logTypeEnum.getType())) {
                return logTypeEnum;
            }
        }
        return null;
    }

    /**
     * 获取所有的Enum列表
     * @return
     */
    public static List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (LogTypeEnum logTypeEnum : LogTypeEnum.values()) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("key", logTypeEnum.getType());
            map.put("value", logTypeEnum.getName());
            list.add(map);
        }
        return list;
    }
}
