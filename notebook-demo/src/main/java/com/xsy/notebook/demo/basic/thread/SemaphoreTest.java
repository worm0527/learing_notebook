package com.xsy.notebook.demo.basic.thread;

import java.util.concurrent.Semaphore;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class SemaphoreTest {

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3);
    for (int i = 0; i < 9; i++) {
      new Thread(() -> {
        try {
          semaphore.acquire();
          System.out.println(Thread.currentThread().getName() + "占用停车位");
          Thread.sleep(3000);
          System.out.println(Thread.currentThread().getName() + "离开停车场");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }, "线程" + i).start();
    }
  }

}
