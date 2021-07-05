package com.xsy.notebook.array;

/**
 * @author shuyuan.xu
 * @date 2020-06-26.
 */
public class GenericsArray<T> implements AbstractArray<T> {

  private T[] arr;

  private int size;

  private GenericsArray(int capacity) {
    arr = (T[]) new Object[capacity];
    size = 0;
  }

  private GenericsArray() {
    this(10);
  }

  public void add(T value, int index) {
    checkIndexForAdd(index);

    if (size >= arr.length) { // 容量不足进行扩容
      T[] newData = (T[]) new Object[arr.length * 2];
      for (int i = 0; i < size; i++) {
        newData[i] = arr[i];
      }
      arr = newData;
    }

    for (int i = size; i > index; i--) {
      arr[i] = arr[i - 1];
    }

    arr[index] = value;
    size++;
  }

  /**
   * 从尾部插入
   *
   * @param value
   * @return
   */
  public void add(T value) {
    this.add(value, size);
  }

  /**
   * 从首部插入
   *
   * @param value
   * @return
   */
  public void addFirst(T value) {
    this.add(value, 0);
  }

  public T remove(int index) {
    checkIndex(index);

    T value = arr[index];

    for (int i = index; i < size - 1; i++) {
      arr[i] = arr[i + 1];
    }
    size--;

    return value;
  }

  public T removeFirst() {
    return this.remove(0);
  }

  public T removeLast() {
    return this.remove(size - 1);
  }

  /**
   * 根据下标获取元素值
   *
   * @param index
   * @return
   */
  public T get(int index) {
    checkIndex(index);
    return arr[index];
  }

  @Override
  public T set(T value, int index) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * 设置给定下标未知的值
   *
   * @param index
   * @param value
   */
  public void set(int index, T value) {
    checkIndex(index);
    arr[index] = value;
  }

  public boolean contains(T value) {
    return find(value) >= 0;
  }

  public int find(T value) {
    if (value == null) {
      for (int i = 0; i < size; i++) {
        if (arr[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (value.equals(arr[i])) {
          return i;
        }
      }
    }

    return -1;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GenericsArray{arr=[");
    for (int i = 0; i < size; i++) {
      stringBuilder.append(arr[i]);
      if (i != size - 1) {
        stringBuilder.append(", ");
      }
    }
    stringBuilder.append("],  size=" + size);
    return stringBuilder.toString();
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("index:" + index + ", size:" + size);
    }
  }

  private void checkIndexForAdd(int index) {
    if (index < 0 || index > size) {
      throw new RuntimeException("index:" + index + ", size:" + size);
    }
  }

  public static void main(String[] args) {
    GenericsArray<Integer> array = new GenericsArray<>(5);
    for (int i = 0; i < 10; i++) {
      array.add(i);
    }
    System.out.println(array);

    array.add(0, 10);
    System.out.println(array);

    array.remove(0);
    System.out.println(array);

    System.out.println(array.contains(11));
    System.out.println(array.find(2));
  }

}
