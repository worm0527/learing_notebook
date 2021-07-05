package com.xsy.notebook.guicetest;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shuyuan.xu
 * @date 2020-07-21.
 */
public class Demo {

  public static class DemoModule extends AbstractModule {

    @Provides
//    @Message
    public String message() {
      return "hello world";
    }

    @Provides
//    @Count
    public int count() {
      return 3;
    }

  }

  @Retention(value = RetentionPolicy.RUNTIME)
  public @interface Message {}

  @Retention(value = RetentionPolicy.RUNTIME)
  public @interface Count {}

  private String message;

  private int count;

  @Inject
  public Demo(String message, int count) {
    this.message = message;
    this.count = count;
  }

  public void say() {
    for (int i = 0; i < count; i++) {
      System.out.println(message);
    }
  }

  public static void main(String[] args) {
    // ApplicationContext.getInstance
    Injector injector = Guice.createInjector(new DemoModule());
    injector.getInstance(Demo.class).say();
  }

}
