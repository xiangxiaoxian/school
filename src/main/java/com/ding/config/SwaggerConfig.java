package com.ding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author dhr
 * @version 1.0.0 @ClassName SwaggerConfig.java @Description TODO
 * @createTime 2021年01月07日 16:33:00
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    //配置swagger
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles= Profiles.of("dev","test");
        //获取项目的环境
        //判断当前环境是否符合设定环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .enable(flag)
        .groupName("XR")
        .select()
        .apis(RequestHandlerSelectors.any())
        .build();
    }

    //配置apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact=new Contact("丁厚仁","","2510998796@qq.com");
        return new ApiInfo("学校软件","开始出发","v1.0","",contact,"spring-boot2",null,new ArrayList<>());
    }
}
