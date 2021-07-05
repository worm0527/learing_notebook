package com.xsy.notebook.demo.spi;

/**
 * @author shuyuan.xu
 * @date 2020-11-16.
 */
public class Logback implements Log {

  @Override
  public void info(String info) {
    System.out.println("Logback:" + info);
  }
}
