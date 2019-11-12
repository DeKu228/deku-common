package com.deku.common.config.properties;

import lombok.Data;

/**
 * Swagger默认配置属性
 *
 * @Author: deku
 * @Date: 2019/1/25
 */
@Data
public class SwaggerProperties {
    private String title = "Swagger API接口文档";
    private String description = "欢迎来到Swagger API接口文档";
    private String version = "1.0";
    private String license = "Apache License 2.0";
    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";
    private String contactName = "小白";
    private String contactUrl = "https://github.com/dekuCode2016";
    private String contactEmail = "208865935@qq.com";
}
