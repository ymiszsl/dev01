package com.fc;

import com.fc.entity.Car;
import com.fc.entity.GirlFriend;
import com.fc.entity.Son;
import com.fc.entity.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        //看看有没有女朋友如果有的话，就获取容器，获取对象
        if (run.containsBean("girFriend")) {
            GirlFriend bean = run.getBean(GirlFriend.class);
            System.out.println("有对象" + bean);
        } else {
            System.out.println("路见不平也是我");
        }

        if (run.containsBean("son")) {
            Son son = run.getBean(Son.class);
            System.out.println("有孩子：" + son);
        } else {
            System.out.println("没孩子");
        }

        if (run.containsBean("wife")) {
            Wife wife = run.getBean(Wife.class);
            System.out.println("有老婆：" + wife);
        } else {
            System.out.println("没老婆");
        }
        //直接拿car就拿了两个不知道是哪一个
        Car car = run.getBean("car", Car.class);

        System.out.println(car);

//        Car car1 = run.getBean("car2", Car.class);
//
//        System.out.println(car1);
    }
}