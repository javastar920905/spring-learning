package com.ouzhx.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by ouzhx on 2017/11/17.
 *
 * 一个日志切面,xml方式演示--未完成
 */
@Component
public class LogAspect {
  public void before(JoinPoint joinpoint) {
    System.out.println("....invoke method before");
  }

  public void after(JoinPoint joinpoint) {
    System.out.println("....invoke method after");
  }

  public void afterReturn(JoinPoint joinpoint) {
    System.out.println("....获得返回值后");
  }

  public void whenException(JoinPoint joinpoint) {
    System.out.println("....invoke method whenException");
  }
}
