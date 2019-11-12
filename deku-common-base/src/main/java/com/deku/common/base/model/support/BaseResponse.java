package com.deku.common.base.model.support;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: deku
 * @Date: 2019/11/2
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    /**
     * Response code.
     */
    private Integer code;

    /**
     * Response message.
     */
    private String message;

    /**
     * Response development message
     */
    private String devMessage;

    /**
     * Response data
     */
    private T data;

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @NonNull
    public static <T> BaseResponse<T> ok(Integer code, @Nullable String message, @Nullable T data) {
        return new BaseResponse<>(code, message, data);
    }

    @NonNull
    public static <T> BaseResponse<T> ok(Integer code, @Nullable String message) {
        return new BaseResponse<>(code, message, null);
    }

    @NonNull
    public static <T> BaseResponse<T> ok(@Nullable String message, @Nullable T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), message, data);
    }

    @NonNull
    public static <T> BaseResponse<T> ok(@Nullable String message) {
        return ok(message, null);
    }

    @NonNull
    public static <T> BaseResponse<T> ok(@NonNull T data) {
        return ok(HttpStatus.OK.getReasonPhrase(), data);
    }

}
