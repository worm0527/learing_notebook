package com.xsy.notebook.demo.basic.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RuntimeConstantPoolOOM {

    // -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10m
    public static void main(String[] args) {
        // 使用列表持有引用
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(UUID.randomUUID()).intern());
        }
    }

}
