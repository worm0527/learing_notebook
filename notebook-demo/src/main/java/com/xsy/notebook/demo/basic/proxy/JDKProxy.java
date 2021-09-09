package com.xsy.notebook.demo.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    public Test test;

    public JDKProxy(Test test) {
        this.test = test;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        if (Object.class.equals(method.getDeclaringClass())) {
//            return method.invoke(this, args);
//        }

        if ("test".equals(method.getName())) {
            System.out.println("invoke test");
            return method.invoke(test, args);
        }

        return method.invoke(test, args);
    }

    @Override
    public String toString() {
        return "JDKProxy{" +
                "test=" + test +
                '}';
    }

    public static Test getInstance(Test test) {
        JDKProxy jdkProxy = new JDKProxy(test);
        return (Test) Proxy.newProxyInstance(test.getClass().getClassLoader(),
                new Class[]{Test.class}, jdkProxy);
    }

    public static void main(String[] args) {
        Test test = getInstance(new TestImpl());
        System.out.println(test);
        test.test();
    }

}
