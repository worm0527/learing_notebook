package com.xsy.notebook.demo.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author shuyuan.xu
 * @date 2021-05-16.
 */
public class BlockingQueueTest {

  public static void main(String[] args) throws InterruptedException {
//    exceptionMethod();
//    specialMethod();
    blockMethod();
  }

  private static void blockMethod() throws InterruptedException {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    queue.put("a");
    queue.put("b");
    queue.put("c");
//    queue.put("d");

    System.out.println(queue.take());
    System.out.println(queue.take());
    System.out.println(queue.take());
    System.out.println(queue.take());
  }

  private static void specialMethod() {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    System.out.println(queue.offer("a"));
    System.out.println(queue.offer("b"));
    System.out.println(queue.offer("c"));
    System.out.println(queue.offer("d"));

    System.out.println(queue.peek());

    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }

  private static void exceptionMethod() {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    System.out.println(queue.add("a"));
    System.out.println(queue.add("b"));
    System.out.println(queue.add("c"));
//    System.out.println(queue.add("d"));

    System.out.println(queue.element());

    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
//    System.out.println(queue.remove());
  }

}
