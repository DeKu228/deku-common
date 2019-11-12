package com.deku.common.base.constant;

/**
 * 通用常量
 *
 * @Author: deku
 * @Date: 2019/1/22
 */
public class GlobalConstant {
    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "X-Real-IP";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    public static final int MAX_IP_LENGTH = 15;

    public final static String DEFAULT_LOCATION = "XX XX";
    public final static String IP = "http://ip.taobao.com/service/getIpInfo.php";

    public static final String ROOT_PREFIX = "dekucloud";

    public static final class Sys {
        //全局用户名
        public static final String TOKEN_AUTH_DTO = "CURRENT_USER_DTO";
    }

    /** 符号 **/
    public static final class Symbol {

        public static final String COMMA = ",";
        public static final String SPOT = ".";
    }

    /** 通用状态码（针对vue-admin-template） **/
    public static final class CodeStatus {
        //请求成功
        public static final int OK = 20000;
        //请求失败
        public static final int FAIL = 20002;
        //熔断请求
        public static final int BREAKING = 20004;
        //非法请求
        public static final int ILLEGAL_REQUEST = 50000;
        //非法令牌
        public static final int ILLEGAL_TOKEN = 50008;
        //其他客户登录
        public static final int OTHER_CLIENTS_LOGGED_IN = 50012;
        //令牌已过期
        public static final int TOKEN_EXPIRED = 50014;
    }
}
