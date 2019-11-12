package com.deku.common.base.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 通用异常
 *
 * @Author: deku
 * @Date: 2019/1/22
 */
@Slf4j
public abstract class BaseException extends RuntimeException {

    /** 错误码 **/
    private String errCode;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
        log.error("系统遇到如下异常，异常码：{}>>>异常信息：{}", errCode, message);
    }

    public BaseException(String errCode, String msgFormat, Object... params) {
        super(String.format(msgFormat, params));
        this.errCode = errCode;
        log.error("系统遇到如下异常，异常码：{}>>>异常信息：{}", errCode, String.format(msgFormat, params));
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
