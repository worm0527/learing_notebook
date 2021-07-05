package com.xsy.notebook.graph;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author shuyuan.xu
 * @date 2020-09-05.
 */
public class GraphSearch {

  @Data
  private static class Vertex {

    private int data;

    public Vertex(int data) {
      this.data = data;
    }
  }

  @Data
  private static class Graph {

    private Vertex[] vertices;

    private LinkedList[] adj;

  }

  public static void main(String[] args) {
  }

}
