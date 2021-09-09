package com.xsy.notebook.demo.basic.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author shuyuan.xu
 * @date 2021-05-09.
 */
public class TreeSetTest {

  public static void main(String[] args) {
    Set set = new TreeSet();
    set.add("A");
    set.add("C");
    set.add("B");
    System.out.println(set);
  }

}
