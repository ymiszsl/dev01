package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//先赵那个大文件
@Profile("product")
//找文件内部的
@ConfigurationProperties("student")
@Data
//注入
@Component

public class Son implements  Student{
    private  String name;
    private  Integer age;
}
