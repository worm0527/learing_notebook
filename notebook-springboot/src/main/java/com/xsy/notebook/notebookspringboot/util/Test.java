package com.xsy.notebook.notebookspringboot.util;

public class Test {

    private int testVal = 1234;

    private String strVal = "strVal";

    private final static int staticVal = 7654321;

    private static String staticStrVal = "thisStaticStrVal";

    public Test() {

    }

    public Test(int testVal) {
        this.testVal = testVal;
    }

    public static void main(String[] args) {
        mytest();
    }

    @Deprecated
    private static void mytest() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);
    }

    public static void mytest1() {
        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2==str1);
    }

    public static void mytest3() {
        String h = new String("cc");
        String intern = h.intern();
        System.out.println(intern == h); // 返回false
    }

    public static void mytest4() {
        String s = "ab";    // 常量池创建"ab"
        String s1 = new String("ab"); // 堆里面创建"ab"，因为常量池已有"ab"，不会在常量池再缓存一次
        String str3 = "ab" + "cd"; // 连接之后常量池是否还有"ab"??在常量池连接成"abcd"后"ab"和"cd"是否还存在？
        String s2 = s1.intern(); // 如果常量池还有"ab"，s2指向常量池"ab"，如果没有，则放入s1地址，s2就指向s1，即s2指向堆里的"ab"
        System.out.println(s2 == s1); // 如果true，则s2是堆里的"ab".说明"ab"+"cd"连接后，常量池只有"abcd","ab"和"cd"被回收了
        // 结果运行出来是false，说明"ab"+"cd"连接之后，不仅存在"ab","cd", 还存在"abcd"
    }

    public void mytest5() {
        byte byteVal = 10;
        short shortVal = 32767;
        char charVal = 'A';
        int intVal = 10000000;
        long longVal = 40;
        float floatVal = 5;
        double doubleVal = 6;
        boolean booleanVal = false;
    }

    public int mytest6() {
        int a = 3;
        int b = 4;
        return a + b;
    }

    public class InnerClass {

    }

}
