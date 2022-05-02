package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//注入
//必须将当前类的对象注册到Spring容器中才能使用ConfigurationProperties
@Component
@ConfigurationProperties(prefix = "student.car")
public class Car {
    private String brand;
    private String color;
}
