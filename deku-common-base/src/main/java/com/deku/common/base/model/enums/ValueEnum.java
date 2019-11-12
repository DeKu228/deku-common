package com.deku.common.base.model.enums;

import org.springframework.util.Assert;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: deku
 * @Date: 2019/11/6
 */
public interface ValueEnum<T> {

    /**
     * 通过value获取对应的Enum
     * @param enumType
     * @param value
     * @param <V>
     * @param <E>
     * @return
     */
    static<V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value) {
        Assert.notNull(enumType, "enum type must not be null");
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(enumType.isEnum(), "type must be an enum type");

        return Stream.of(enumType.getEnumConstants())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown database value: " + value));
    }

    T getValue();
}
