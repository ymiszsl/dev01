package com.fc.config;

import com.fc.entity.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 开启配置属性绑定
@EnableConfigurationProperties(Person.class)
public class PersonConfig {
    @Bean
    //类似于注入进去
    public Person person() {

        return new Person();
    }
}
