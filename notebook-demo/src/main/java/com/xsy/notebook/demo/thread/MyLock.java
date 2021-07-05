package com.xsy.notebook.demo.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class MyLock {

  private AtomicReference<Thread> lock = new AtomicReference<>();

  public void lock() {
    Thread currentThread = Thread.currentThread();
    System.out.println(currentThread.getName() + " come in!");
    while (!lock.compareAndSet(null, currentThread)) {
      try {
        Thread.sleep(500);
        System.out.println(currentThread.getName() + " wait to lock");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " locked");
  }

  public void unlock() {
    Thread currentThread = Thread.currentThread();
    lock.compareAndSet(currentThread, null);
    System.out.println(currentThread.getName() + " unlock");
  }

  public static void main(String[] args) throws InterruptedException {
    MyLock myLock = new MyLock();
    new Thread(() -> {
      myLock.lock();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        myLock.unlock();
      }
    }, "t1").start();

    Thread.sleep(100);

    new Thread(() -> {
      myLock.lock();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        myLock.unlock();
      }
    }, "t2").start();
  }

}
