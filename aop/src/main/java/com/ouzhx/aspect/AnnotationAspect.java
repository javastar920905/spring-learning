package com.ouzhx.aspect;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by ouzhx on 2017/11/17. 注解方式实现切面
 */
@Component
@Aspect // 这个类声明为切面类
public class AnnotationAspect {
  /**
   * 具体方法: 权限修饰符[可省略|public|private] 返回类型[*|void] 方法名[包.类.方法](参数) throws 异常
   * 
   * 借鉴linux url, cd .或cd .. (service..当前包和任意子包)
   *
   * execution("public * com.ouzhx.service.AuthService.login(..)")
   * execution("public * com.ouzhx.service..*.*(String,String)")
   * execution("public * com.ouzhx.service..*.*(..)")
   */
  // 声明切入点(利用反射机制,读取切面中的所有注解信息,service下的所有方法都接收到通知)
  @Pointcut("excution(* com.ouzhx.service..*(..)")
  public void pointcutConfig() {}

  @Before(value = "pointcutConfig()")
  public void before(JoinPoint joinpoint) {
    System.out.println("....invoke method before");
  }

  @After(value = "pointcutConfig()")
  public void after(JoinPoint joinpoint) {
    System.out.println("....invoke method after");
  }

  @AfterReturning("pointcutConfig()")
  public void afterReturn(JoinPoint joinpoint) {
    System.out.println("....获得返回值后");
  }

  @AfterThrowing("pointcutConfig()")
  public void whenException(JoinPoint joinpoint) {
    System.out.println("切点的参数: " + Arrays.toString(joinpoint.getArgs()));
    System.out.println("切点的方法:" + joinpoint.getKind());
    System.out.println("...:" + joinpoint.getSignature());
    System.out.println("生成后打代理对象:" + joinpoint.getTarget());
    System.out.println("当前类本身:" + joinpoint.getThis());
    System.out.println("....invoke method whenException");
  }
}
