package com.deku.common.base.enums;

/**
 * 常用枚举类型
 *
 * @Author: deku
 * @Date: 2019/1/18
 */
public enum CommonEnum {
    /** 通用成功 **/
    SUCCESS("SUCCESS","成功"),
    /** 通用失败 **/
    FAILURE("FAILURE","失败"),
    /** 502 **/
    BAD_GATEWAY("BAD_GATEWAY", "从上游服务器接收到无效的响应");

    private String errCode;
    private String errMsg;

    CommonEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
