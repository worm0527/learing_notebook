package com.xsy.notebook.demo.basic.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuyuan.xu
 * @date 2021-05-18.
 */
public class HashSetTest {

  public static void main(String[] args) {
    Set set = new HashSet();
    for (Integer i = 0; i < 100; i++) {
      set.add(i);
      set.remove(i - 1);
    }
    System.out.println(set.size());
  }

}
