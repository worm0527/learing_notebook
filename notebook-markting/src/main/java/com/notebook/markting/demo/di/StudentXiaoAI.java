package com.notebook.markting.demo.di;

import com.google.inject.Inject;

import javax.inject.Named;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
public class StudentXiaoAI {

  @Inject
  @Named("service1")
  private Service service;

  @Inject
  @Named("service2")
  private Service service2;

  public void awaken() {
    System.out.println(service.sayHello());
    System.out.println(service2.sayHello());
    System.out.println(service);
    System.out.println(service2);
  }

}
