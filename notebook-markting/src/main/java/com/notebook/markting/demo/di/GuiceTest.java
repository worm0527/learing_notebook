package com.notebook.markting.demo.di;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author shuyuan.xu
 * @date 2021-01-12.
 */
public class GuiceTest {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new DemoModule());
//    Service service = injector.getInstance(Service.class);
//    System.out.println(service.sayHello());
    StudentXiaoAI xiaoai = injector.getInstance(StudentXiaoAI.class);
    xiaoai.awaken();
  }

}
