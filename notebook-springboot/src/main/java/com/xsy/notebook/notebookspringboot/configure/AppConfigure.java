package com.xsy.notebook.notebookspringboot.configure;

import com.xsy.notebook.notebookspringboot.pojo.Pet;
import com.xsy.notebook.notebookspringboot.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
@Configuration
@ConditionalOnMissingBean(name = "tom1")
public class AppConfigure {

    @Bean(name = "user")
    public User getUser() {
        return new User("zhangsan", 18);
    }

    @Bean(name = "tom")
    public Pet getPet() {
        return new Pet("tom");
    }

}
