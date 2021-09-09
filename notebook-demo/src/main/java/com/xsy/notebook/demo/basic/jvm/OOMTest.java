package com.xsy.notebook.demo.basic.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author shuyuan.xu
 * @date 2021-05-18.
 */
public class OOMTest {

  // -Xms50m -Xmx50m
  public static void main(String[] args) throws InterruptedException {
//    heapOOM1();
//    permOOM();
    stackOOM();
//    stackOOM1();
//    directOOM();
  }

  // -Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
  // java.lang.OutOfMemoryError: Java heap space
  public static void heapOOM() {
    byte[] bytes = new byte[1024 * 1024 * 10];
  }

  // java.lang.OutOfMemoryError: Java heap space
  public static void heapOOM1() {
    List<OOMTest> tests = new ArrayList<>();
    while (true) {
      tests.add(new OOMTest());
    }
  }

  public static void stackOOM() {
    while (true) {
      new Thread(() -> {
        while (true) {

        }
      }).start();
    }
  }

  // java.lang.StackOverflowError
  public static void stackOOM1() {
    stackOOM1();
  }

  public static void stackOOM2() {

  }

  public static void permOOM() {
    List<String> list = new ArrayList<String>();
    while (true) {
      list.add(String.valueOf(UUID.randomUUID().toString()).intern());
    }
  }

  public static void directOOM() {
    final int _1M = 1024 * 1024 * 1;
    List<ByteBuffer> buffers = new ArrayList<>();
    int count = 1;
    while (true) {
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
      buffers.add(byteBuffer);
      System.out.println(count++);
    }
  }

}
