package com.xsy.notebook.notebookspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "hi, springboot";
    }

}
