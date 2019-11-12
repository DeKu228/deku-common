package com.deku.common.base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 *
 * @Author: deku
 * @Date: 2018/12/27
 */
@SuppressWarnings("unchecked")
public class JsonUtils {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /** 将Object转化为JSON字符串 **/
    public static String objectToJson(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 将JSON字符串转化为对象 **/
    public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            return OBJECT_MAPPER.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 将Map转化为JSON **/
    public static String mapToJson(Map map) {
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /** 将JSON字符串转化成Map **/
    public static <T> Map<String, Object> jsonToMap(String jsonString) {
        try {
            OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return OBJECT_MAPPER.readValue(jsonString, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 将JSON字符串转化成Map **/
    public static <T> Map<String, T> jsonToMap(String jsonString, Class<T> clazz) throws Exception {
        Map<String, Map<String, Object>> map = OBJECT_MAPPER.readValue(jsonString, new TypeReference<Map<String, T>>() {
        });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), mapToPojo(entry.getValue(), clazz));
        }
        return result;
    }

    /** 将Map转换为Pojo **/
    public static <T> T mapToPojo(Map map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        List<T> list = null;
        try {
            list = (List<T>) OBJECT_MAPPER.readValue(jsonArrayStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 获取泛型的 Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
