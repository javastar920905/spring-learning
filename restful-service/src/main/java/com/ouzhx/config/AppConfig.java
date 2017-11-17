package com.ouzhx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ouzhx on 2017/4/13.
 */
@SpringBootApplication
// @EnableAspectJAutoProxy
@ComponentScan("com.ouzhx")
public class AppConfig {
  public static void main(String[] args) {
    SpringApplication.run(AppConfig.class);
  }
}
