package com.notebook.markting.demo.di;

import com.google.inject.Singleton;

import javax.inject.Named;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
public class ServiceImpl implements Service {

  @Override
  public String sayHello() {
    return "hello";
  }
}
