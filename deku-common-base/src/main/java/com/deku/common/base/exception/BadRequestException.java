package com.deku.common.base.exception;

import org.springframework.http.HttpStatus;

/**
 * 错误请求异常
 *
 * @Author: deku
 * @Date: 2019/11/6
 */
public class BadRequestException extends WBlogException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
