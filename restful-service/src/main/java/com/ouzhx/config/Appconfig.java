package com.ouzhx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ouzhx on 2017/4/13.
 */
@SpringBootApplication
@ComponentScan("com.ouzhx.controller")
public class Appconfig {
  public static void main(String[] args) {
    SpringApplication.run(Appconfig.class);
  }
}
