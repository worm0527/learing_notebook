package com.xsy.notebook.demo.grep;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuyuan.xu
 * @date 2021-01-11.
 */
public class Test1 {

  public static void main(String[] args)
      throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Map<String, String> map = new HashMap<>(8);
    map.put("hollis1", "hollischuang");
    map.put("hollis2", "hollischuang");
    map.put("hollis3", "hollischuang");

    Class<?> mapType = map.getClass();

    Method capacity = mapType.getDeclaredMethod("capacity");
    capacity.setAccessible(true);
    System.out.println("capacity : " + capacity.invoke(map));

    Field size = mapType.getDeclaredField("size");
    size.setAccessible(true);
    System.out.println("size : " + size.get(map));

    Field threshold = mapType.getDeclaredField("threshold");
    threshold.setAccessible(true);
    System.out.println("threshold : " + threshold.get(map));

    Field loadFactor = mapType.getDeclaredField("loadFactor");
    loadFactor.setAccessible(true);
    System.out.println("loadFactor : " + loadFactor.get(map));

    Test test = new Test();
    test.proTest();
  }

  public static int tableSizeFor(int cap) {

    int MAXIMUM_CAPACITY = 1 << 30;

    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }

}
