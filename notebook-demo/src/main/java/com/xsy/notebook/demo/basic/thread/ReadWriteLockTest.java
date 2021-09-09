package com.xsy.notebook.demo.basic.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class ReadWriteLockTest {

  public static void main(String[] args) throws InterruptedException {
    Cache cache = new Cache();
    for (int i = 0; i < 5; i++) {
      int finalI = i;
      new Thread(() -> cache.set(finalI + "", finalI + ""), "t-" + i).start();
    }

    Thread.sleep(10);

    for (int i = 0; i < 5; i++) {
      int finalI = i;
      new Thread(() -> cache.get(finalI + ""), "tt-" + i).start();
    }
  }

  private static class Cache {

    private Map<String, String> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void set(String key, String value) {
      readWriteLock.writeLock().lock();
      try {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "set value start.");
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(currentThread.getName() + "set value end.");
      } finally {
        readWriteLock.writeLock().unlock();
      }
    }

    public void get(String key) {
      readWriteLock.readLock().lock();
      try {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "get value start.");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        String value = map.get(key);
        System.out.println(currentThread.getName() + "get value end. value=" + value);
      } finally {
        readWriteLock.readLock().unlock();
      }
    }

  }

}
