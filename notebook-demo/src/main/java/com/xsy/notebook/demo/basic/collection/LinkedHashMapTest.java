package com.xsy.notebook.demo.basic.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shuyuan.xu
 * @date 2021-05-09.
 */
public class LinkedHashMapTest {

  public static void main(String[] args) {
    Map<String, String> linkedhashmap = new LinkedHashMap<>(16, 0.75F, true);
    linkedhashmap.put("1", "1");
    linkedhashmap.put("2", "2");
    linkedhashmap.put("3", "3");
    linkedhashmap.get("1");
    System.out.println(linkedhashmap);
  }

}
