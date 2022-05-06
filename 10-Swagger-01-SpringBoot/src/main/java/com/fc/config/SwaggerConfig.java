package com.fc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
//配置类
@EnableSwagger2WebMvc
//必须写
public class SwaggerConfig {
    @Bean
    //注入
    public Docket createDocket(){
        // 创建核心摘要对象，参数为文档类型：swagger2
        return  new Docket(DocumentationType.SWAGGER_2)

        //添加api的基本信息
        .apiInfo(apiInfo())
                //对基本信息进行查询
        .select()
                //扫描指定包下的使用swagger注解
        .apis(RequestHandlerSelectors.basePackage("com.fc"))
                //支持任意路径
        .paths(PathSelectors.any())
                //构建
        .build();
    }
    // 配置API的基本信息（会在http://项目实际地址/swagger-ui.html页面显示）
    private ApiInfo apiInfo(){
      return  new ApiInfoBuilder()
        //api标题
        .title("测试标题")
              //描述
        .description("第一次使用")
              //联系人
        .contact(new Contact("ymiszsl","https://github.com/ymiszsl","@aa.com"))
              //版本号
        .version("1.0")
              //许可证
        .license("Apache 2.0")
              //服务条款
        .termsOfServiceUrl("/https://swagger.io")
              .build();
    }
}
