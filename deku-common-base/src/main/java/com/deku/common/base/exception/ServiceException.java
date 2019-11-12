package com.deku.common.base.exception;

import org.springframework.http.HttpStatus;

/**
 * 服务器内部异常
 *
 * @Author: deku
 * @Date: 2019/11/6
 */
public class ServiceException extends WBlogException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
