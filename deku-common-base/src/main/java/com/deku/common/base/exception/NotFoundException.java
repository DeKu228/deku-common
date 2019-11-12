package com.deku.common.base.exception;

import org.springframework.http.HttpStatus;

/**
 * Not Found异常
 *
 * @Author: deku
 *  * @Date: 2019/1/22
 */
public class NotFoundException extends WBlogException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
