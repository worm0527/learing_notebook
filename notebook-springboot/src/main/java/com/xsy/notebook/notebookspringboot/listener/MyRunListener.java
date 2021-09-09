package com.xsy.notebook.notebookspringboot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyRunListener implements SpringApplicationRunListener {

    public MyRunListener(SpringApplication application, String[] args) {
        System.out.println(simpleName() + "init");
    }

    private String simpleName() {
        return getClass().getSimpleName();
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println(simpleName() + " environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println(simpleName() + " contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println(simpleName() + " contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println(simpleName() + " started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println(simpleName() + " running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println(simpleName() + " failed");
    }
}
