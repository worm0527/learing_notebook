package com.xsy.notebook.demo.basic.string;

public class StringTest {

    public static void main(String[] args) {
        test7();
    }

    public static void test1() {
        String s1 = new String("1");
        String s2 = new String("1");
        System.out.println(s1 == s2); // false
    }

    public static void test2() {
        String s1 = "1";
        String s2 = "1";
        System.out.println(s1 == s2); // true
    }

    public static void test3() {
        String s1 = new String("1");
        String s2 = "1";
        System.out.println(s1 == s2); // false
    }

    public static void test4() {
        String s1 = "1";
        String s2 = s1.intern();
        System.out.println(s1 == s2); // true
    }

    public static void test5() {
        String s1 = "1" + "2";
        String s2 = "12";
        System.out.println(s1 == s2); // true
    }

    public static void test6() {
        String s1 = new String("1111") + new String("222");
        s1.intern();
        String s2 = "1111222";
        System.out.println(s1 == s2); // true
    }

    public static void test7() {
        String s1 = new String("1111") + new String("222");
        String s2 = "1111222";
        s1.intern();
        System.out.println(s1 == s2); // false
    }

}
