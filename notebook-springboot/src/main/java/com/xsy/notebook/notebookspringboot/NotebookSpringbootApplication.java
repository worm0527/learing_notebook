package com.xsy.notebook.notebookspringboot;

import com.xsy.notebook.notebookspringboot.configure.AppConfigure;
import com.xsy.notebook.notebookspringboot.pojo.Car;
import com.xsy.notebook.notebookspringboot.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan("com.xsy")
@SpringBootApplication
public class NotebookSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(NotebookSpringbootApplication.class, args);

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//        User user = context.getBean("getUser", User.class);
//        System.out.println(user);
//
//        AppConfigure appConfigure = context.getBean(AppConfigure.class);
//        System.out.println(appConfigure);
//        System.out.println(appConfigure.getUser() == appConfigure.getUser());

        boolean user = context.containsBean("user");
        System.out.println("context has user bean:" + user);

        String carBrand = context.getBean(Car.class).getBrand();
        System.out.println(carBrand);
    }

}
