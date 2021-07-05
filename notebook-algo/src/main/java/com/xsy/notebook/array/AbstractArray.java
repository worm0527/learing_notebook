package com.xsy.notebook.array;

/**
 * @author shuyuan.xu
 * @date 2020-07-25.
 */
public interface AbstractArray<T> {

  /**
   * 增加元素
   *
   * @param value
   * @return
   */
  void add(T value);

  /**
   * 在指定位置增加元素
   *
   * @param value
   * @param index
   * @return
   */
  void add(T value, int index);

  /**
   * 移除指定位置元素
   *
   * @param index
   * @return
   */
  T remove(int index);

  /**
   * 获取给定位置元素
   *
   * @param index
   * @return
   */
  T get(int index);

  /**
   * @param value
   * @param index
   * @return old value
   */
  T set(T value, int index);

  /**
   * 当前数组大小
   *
   * @return
   */
  int size();

  /**
   * 数组是否为空
   *
   * @return
   */
  boolean isEmpty();

}
