package com.xsy.notebook.demo.grep;

import java.util.StringJoiner;

/**
 * @author shuyuan.xu
 * @date 2021-02-26.
 */
public class Test2 {

  public static void main(String[] args) {
    StringJoiner sj1 = new StringJoiner(",", "[", "]");
    sj1.add(1 + "");
    sj1.add(2 + "");
    sj1.add(3 + "");

    StringJoiner sj2 = new StringJoiner("|", "{", "}");
    sj2.add(4 + "");
    sj2.add(5 + "");
    sj2.add(6 + "");

    System.out.println(sj1);
  }

}
