package com.notebook.markting.demo.di;

import javax.inject.Named;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
//@Named("service2")
public class Service2Impl implements Service {

  @Override
  public String sayHello() {
    return "hello world";
  }
}
