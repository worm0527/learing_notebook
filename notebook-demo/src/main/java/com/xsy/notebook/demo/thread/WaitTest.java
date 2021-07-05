package com.xsy.notebook.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class WaitTest {

  private volatile int flag = 1;

  private Object obj = new Object();

  public void printOdd() throws InterruptedException {
    synchronized (obj) {
      for (int i = 1; i < 10; i += 2) {
        System.out.println("odd:" + i);
        obj.notify();
        obj.wait();
      }
    }
  }

  public void printEven() throws InterruptedException {
    synchronized (obj) {
      for (int i = 2; i < 10; i += 2) {
        System.out.println("even:" + i);
        obj.notify();
        obj.wait();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    WaitTest waitTest = new WaitTest();
    new Thread(() -> {
      try {
        waitTest.printOdd();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "t1").start();

//    TimeUnit.SECONDS.sleep(1L);

    new Thread(() -> {
      try {
        waitTest.printEven();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "t2").start();
  }

}
