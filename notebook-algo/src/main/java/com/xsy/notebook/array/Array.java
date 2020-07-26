package com.xsy.notebook.array;

/**
 * 实现数组的增删改查
 *
 * @author shuyuan.xu, <shuyuan.xu@leyantech.com>
 * @date 2020-06-26.
 */
public class Array {

  private int[] arr;

  /**
   * 实际大小
   */
  private int size;

  /**
   * 无参构造器
   */
  public Array() {
    arr = new int[10];
    size = 0;
  }

  public boolean add(int index, int value) {

    if (size >= arr.length) {
      throw new RuntimeException("Array is full");
    }

    if (index < 0 || index > size) {
      throw new RuntimeException("index:" + index + ", size:" + size);
    }

    for (int i = size; i > index; i--) {
      arr[i] = arr[i - 1];
    }

    arr[index] = value;
    size++;

    return true;
  }

  public boolean add(int value) {
    return this.add(size, value);
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("index:" + index + ", size:" + size);
    }

    return arr[index];
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("index:" + index + ", size:" + size);
    }

    for (int i = index; i < size - 1; i++) {
      arr[i] = arr[i + 1];
    }

    size--;

    return true;
  }

  private void print() {
    System.out.print("[");
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i]);
      if (i != size - 1) {
        System.out.print(",");
      }
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    Array array = new Array();
    array.add(1);
    array.add(2);
    array.add(3);
    array.add(4);
    array.add(5);
    array.add(6);
    array.add(7);
    array.add(9);
    array.print();

    array.add(0, 0);
    array.print();

    System.out.println(array.get(2));
    array.print();

    array.remove(3);
    array.print();
  }

}
