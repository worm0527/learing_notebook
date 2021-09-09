package com.xsy.notebook.demo.basic.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author shuyuan.xu
 * @date 2020-11-16.
 */
public class SpiTest {

  public static void main(String[] args) {
    ServiceLoader serviceLoader = ServiceLoader.load(Log.class);
    Iterator<Log> logIterator = serviceLoader.iterator();
    while (logIterator.hasNext()) {
      logIterator.next().info("Hello SPI");
    }
    while (logIterator.hasNext()) {
      logIterator.next().info("Hello again");
    }
    System.out.println((new String[2]).getClass().getName());
  }

}
