package com.ouzhx.aop;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ouzhx on 2017/11/17. 注解方式实现切面
 * https://docs.spring.io/spring/docs/4.3.12.RELEASE/spring-framework-reference/htmlsingle/#aop
 */
@Component
@Aspect // 这个类声明为切面类
public class AnnotationAspect {
  /**
   * 具体方法: 权限修饰符[可省略|public|private] 返回类型[*|void] 方法名[包.类.方法](参数) throws 异常
   * 
   * 借鉴linux url, cd .或cd .. (service..当前包和任意子包)
   * 切入点错误时项目会无法启动
   */
  // 声明切入点(利用反射机制,读取切面中的所有注解信息,service下的所有方法都接收到通知)
  @Pointcut("execution(* com.ouzhx.controller..*(..))")
  public void pointcutConfig() {}

  @Before(value = "pointcutConfig()")
  public void before(JoinPoint joinpoint) {
    System.out.println("我是前置通知!!!");
    // 获取目标方法的参数信息
    Object[] obj = joinpoint.getArgs();
    // AOP代理类的信息
    joinpoint.getThis();
    // 代理的目标对象
    joinpoint.getTarget();
    // 用的最多 通知的签名
    Signature signature = joinpoint.getSignature();
    // 代理的是哪一个方法
    System.out.println(signature.getName());
    // AOP代理类的名字
    System.out.println(signature.getDeclaringTypeName());
    // AOP代理类的类（class）信息
    signature.getDeclaringType();
    // 获取RequestAttributes
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    // 从获取RequestAttributes中获取HttpServletRequest的信息
    HttpServletRequest request = (HttpServletRequest) requestAttributes
        .resolveReference(RequestAttributes.REFERENCE_REQUEST);
    // 如果要获取Session信息的话，可以这样写：
    // HttpSession session = (HttpSession)
    // requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
    Enumeration<String> enumeration = request.getParameterNames();
    Map<String, String> parameterMap = new HashMap<>();
    while (enumeration.hasMoreElements()) {
      String parameter = enumeration.nextElement();
      parameterMap.put(parameter, request.getParameter(parameter));
    }
    String str = JSON.toJSONString(parameterMap);
    if (obj.length > 0) {
      System.out.println("请求的参数信息为：" + str);
    }
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
