package com.xsy.notebook.linkedlist;

import com.xsy.notebook.array.AbstractArray;

import java.util.Scanner;

/**
 * 单向链表
 *
 * @author shuyuan.xu
 * @date 2020-07-25.
 */
public class MyLinkedList<T> implements AbstractArray<T> {

  private Node<T> first;

  private int size;

  @Override
  public void add(T value) {
    add(value, 0);
  }

  @Override
  public void add(T value, int index) {
    checkPostion(index);
    if (index == 0) {
      Node newNode = new Node(value, first);
      first = newNode;
    } else {
      Node node = nodePrev(index);
      Node newNode = new Node(value, node.next);
      node.next = newNode;
    }
    size++;
  }

  private void checkPostion(int index) {
    if (!(index >= 0 && index <= size)) {
      throw new IllegalArgumentException("size: " + size + ", index:" + index);
    }
  }

  private Node nodePrev(int index) {
    Node n = first;
    for (int i = 0; i < index - 1; i++) {
      n = n.next;
    }
    return n;
  }

  @Override
  public T remove(int index) {
    checkIndex(index);
    T oldValue;
    if (index == 0) {
      oldValue = first.value;
      first = first.next;
    } else {
      Node prevNode = nodePrev(index);
      oldValue = (T) prevNode.next.value;
      prevNode.next = prevNode.next.next;
    }
    size--;
    return oldValue;
  }

  @Override
  public T get(int index) {
    checkIndex(index);
    if (index == 0) {
      return first.value;
    }
    return (T) nodePrev(index).next.value;
  }

  @Override
  public T set(T value, int index) {
    checkIndex(index);
    T oldValue;
    if (index == 0) {
      oldValue = first.value;
      first.value = value;
    } else {
      oldValue = (T) nodePrev(index).next.value;
      nodePrev(index).next.value = value;
    }
    return oldValue;
  }

  private void checkIndex(int index) {
    if (!(index >= 0 && index <= size - 1)) {
      throw new IllegalArgumentException("size: " + size + ", index:" + index);
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    Node node = first;
    String values = "";
    while (node != null) {
      values += node.value + " ";
      node = node.next;
    }
    return "List:{" +values + "}";
  }

  private static final class Node<T> {

    public T value;

    public Node next;

    public Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MyLinkedList<String> list = new MyLinkedList<>();
    list.add("1");
    list.add("2");
    list.add("3", 0);
    list.add("4", 3);
    System.out.println(list);
    System.out.println(list.get(2));
    System.out.println(list.set("100", 3));
    System.out.println(list);
    System.out.println(list.remove(0));
    System.out.println(list);
    System.out.println(list.remove(list.size() - 1));
    System.out.println(list);
  }

}
