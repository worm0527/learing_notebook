package com.xsy.notebook.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class CountDownLatchTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(8);
    for (int i = 0; i < 8; i++) {
      int finalI = i;
      new Thread(() -> {
        System.out.println("同学:" + finalI + "离开教室");
        latch.countDown();
      }).start();
    }
    latch.await();
    System.out.println("关闭教室");
  }

}
