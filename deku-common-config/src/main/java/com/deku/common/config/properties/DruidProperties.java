package com.deku.common.config.properties;

import lombok.Data;

/**
 * 阿里Druid数据监控默认配置
 *
 * @Author: deku
 * @Date: 2019/3/29
 */
@Data
public class DruidProperties {
    private String userName = "root";
    private String password = "root";
}
