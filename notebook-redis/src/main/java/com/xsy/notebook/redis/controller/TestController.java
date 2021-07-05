package com.xsy.notebook.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shuyuan.xu
 * @date 2020-10-31.
 */
@Controller
public class TestController {

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }

}
