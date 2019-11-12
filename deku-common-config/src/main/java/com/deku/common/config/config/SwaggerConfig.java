package com.deku.common.config.config;

import com.deku.common.config.properties.DeKuCloudProperties;
import com.deku.common.config.properties.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 *  Swagger2 生成API文档配置
 * 文档地址：http://localhost:8601/swagger-ui.html
 *
 * @Author: deku
 * @Date: 2019/1/21
 */
@EnableSwagger2
public class SwaggerConfig {

    @Resource
    private DeKuCloudProperties dekuCloudProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /** 添加摘要信息 **/
    private ApiInfo apiInfo() {
        SwaggerProperties swagger = dekuCloudProperties.getSwagger();
        return new ApiInfoBuilder()
                .title(swagger.getTitle())
                .description(swagger.getDescription())
                .version(swagger.getVersion())
                .license(swagger.getLicense())
                .licenseUrl(swagger.getLicenseUrl())
                .contact(new Contact(swagger.getContactName(),swagger.getContactUrl(),swagger.getContactEmail()))
                .build();
    }
}
