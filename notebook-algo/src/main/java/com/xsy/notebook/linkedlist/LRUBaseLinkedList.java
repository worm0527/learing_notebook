package com.xsy.notebook.linkedlist;

import java.util.Scanner;

/**
 * 基于链表的LRU Cache
 *
 * @author shuyuan.xu
 * @date 2020-07-05.
 */
public class LRUBaseLinkedList<T> {

  /**
   * head头结点，不存储元素（区别于指向头部的节点指针）
   */
  private Node<T> head;

  private Integer capacity;

  private Integer length;

  /**
   * LRU Cache默认大小
   */
  private static final Integer DEFAULT_LRU_CAPATICY = 10;

  public LRUBaseLinkedList() {
    this.head = new Node<>(null, null);
    this.capacity = DEFAULT_LRU_CAPATICY;
    this.length = 0;
  }

  public LRUBaseLinkedList(int capacity) {
    this.head = new Node<>(null, null);
    this.capacity = capacity;
    this.length = 0;
  }

  public void add(T data) {
    Node prevNode = findPrevNode(data);
    if (prevNode != null) {
      removeNode(prevNode);
      addNodeFirst(data);
    } else {
      if (length >= capacity) {
        removeLastNode();
      }
      addNodeFirst(data);
    }
  }

  private Node findPrevNode(T data) {

    Node curr = head;
    while (curr.next != null) {
      if (curr.next.value.equals(data)) {
        return curr;
      }
      curr = curr.next;
    }

    return null;
  }

  private void addNodeFirst(T data) {
    Node node = new Node(data, null);
    node.next = head.next;
    head.next = node;
    length++;
  }

  private void removeNode(Node prveNode) {
    Node removedNode = prveNode.next;
    prveNode.next = removedNode.next;
    removedNode.next = null;
    length--;
  }

  private void removeLastNode() {
    Node curr = head;
    while (curr.next != null && curr.next.next != null) {
      curr = curr.next;
    }

    if (curr != null) {
      removeNode(curr);
    }
  }

  public void printAll() {
    Node curr = head;
    while (curr.next != null) {
      System.out.print(curr.next.value + " ");
      curr = curr.next;
    }
    System.out.println(">>>");
  }

  private static class Node<T> {

    private T value;

    private Node next;

    public Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }
    
  }

  public static void main(String[] args) {
    LRUBaseLinkedList<String> lruCache = new LRUBaseLinkedList<>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String in = scanner.next();
      System.out.println(in);
      lruCache.add(in);
      lruCache.printAll();
    }
  }

}
