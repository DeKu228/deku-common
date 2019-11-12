package com.deku.common.config.properties;

import com.deku.common.base.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 系统中的常用配置
 *
 * @Author: deku
 * @Date: 2019/1/25
 */
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
@Data
public class DeKuCloudProperties {
    /** Swagger API文档配置 **/
    private SwaggerProperties swagger = new SwaggerProperties();
    /** Druid 数据监控配置 **/
    private DruidProperties druid = new DruidProperties();
}
