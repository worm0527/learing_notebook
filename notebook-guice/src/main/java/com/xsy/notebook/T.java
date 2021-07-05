package com.xsy.notebook;

/**
 * @author shuyuan.xu
 * @date 2020-07-21.
 */
public class T {

  public static void main(String[] args) throws InterruptedException {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("shutdown");
    }));
    Thread.sleep(5000);
  }

}
