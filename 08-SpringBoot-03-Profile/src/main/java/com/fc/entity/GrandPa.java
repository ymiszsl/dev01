package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//大哥
@Profile("test")
//小弟
@ConfigurationProperties("student")
@Data
@Component
public class GrandPa implements Student {
    private String name;
    private Integer age;
}
