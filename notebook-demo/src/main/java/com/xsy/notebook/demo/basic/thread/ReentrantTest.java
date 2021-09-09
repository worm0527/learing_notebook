package com.xsy.notebook.demo.basic.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date 2021-05-16.
 */
public class ReentrantTest {

  public static void main(String[] args) {
    Message message = new Message();
//    new Thread(() -> message.sendMsg(), "t1").start();
//    new Thread(() -> message.sendMsg(), "t2").start();
    new Thread(() -> message.sendMsgLock(), "t3").start();
//    new Thread(() -> message.sendMsgLock(), "t4").start();
  }

  private static class Message {

    private Lock lock = new ReentrantLock();

    public void sendMsgLock() {
      lock.lock();
      try {
        System.out.println(Thread.currentThread().getName() + "\t send msg lock");
        sendEmailLock();
      } finally {
        lock.unlock();
      }
    }

    public void sendEmailLock() {
      lock.lock();
      try {
        System.out.println(Thread.currentThread().getName() + "\t send email lock");
      } finally {
        lock.unlock();
      }
    }

    public synchronized void sendMsg() {
      System.out.println(Thread.currentThread().getName() + "\t send msg");
      sendEmail();
    }

    public synchronized void sendEmail() {
      System.out.println(Thread.currentThread().getName() + "\t send email");
    }

  }

}
