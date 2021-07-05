package com.xsy.notebook.notebookspringboot.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaMethodAreaOOM {

    // -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10m
    // org.springframework.cglib.core.CodeGenerationException: java.lang.OutOfMemoryError-->Metaspace
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy)
                    -> methodProxy.invokeSuper(objects, args));
            enhancer.create();
        }
    }

    public static class OOMObject {

    }

}
