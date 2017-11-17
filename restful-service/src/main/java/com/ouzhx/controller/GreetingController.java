package com.ouzhx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ouzhx on 2017/4/13.
 */
@RestController
public class GreetingController {
  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/greeting")
  public String hello() {
    return "hello";
  }
}
