package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 相当于交给容器创建一个对象
@Import({Cat.class})
@Configuration
public class CatConfig {
    @Bean
    // 参数会自动从容器中去获取
    public Cat cat(Cat car) {
        return new Cat("保时捷", "粉色");
    }

}
