package com.xsy.notebook.demo.basic.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class CyclicBarrierTest {

  public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(7, () -> {
      System.out.println("召唤神龙");
    });
    for (int i = 0; i < 7; i++) {
      int finalI = i;
      new Thread(() -> {
        System.out.println("收集到了" + (finalI + 1) + "星珠");
        try {
          barrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
      }).start();
    }
  }

}
