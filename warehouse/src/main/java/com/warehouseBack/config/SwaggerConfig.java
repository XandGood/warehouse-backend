package com.warehouseBack.config;

import springfox.documentation.service.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        // 添加Token请求头参数
        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        tokenParam.name("Authorization")
                .description("Token令牌（格式：Bearer token值）")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false) // 非必填（登录接口不需要）
                .build();
        parameters.add(tokenParam.build());
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.warehouseBack"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }
    // 配置swagger基本信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("XAG", "no.com", "1345959399@qq.com");
        return new ApiInfo(
                "XAG的swagger",
                "warehouse swaager",
                "1.0",
                "no.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}
