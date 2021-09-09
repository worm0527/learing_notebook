package com.xsy.notebook.demo.basic.proxy;

public class TestImpl implements Test{
    @Override
    public void test() {
        System.out.println("this is testImpl");
    }

    @Override
    public String toString() {
        return "impl toString";
    }
}
