package com.ouzhx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ouzhx on 2017/12/4.
 * 
 * 对所有的@Schedule注解进行拦截
 */
@Component
@Aspect
public class ScheduleInterceptor {
  public static final Logger LOGGER = LoggerFactory.getLogger(ScheduleInterceptor.class);

  /**
   * private 方法不能被拦截会报错
   */
  @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled) && (execution(public * *(..)) || execution(protected * *(..)))")
  public void runPositionSpider() {}

  @Before("runPositionSpider()")
  public void beforeMethod(JoinPoint joinPoint) {

    LOGGER.info("方法 {} 经过aop拦截", joinPoint.getSignature().getName());
    /*
     * if (joinPoint.getSignature().getDeclaringType() != GreetingController.class) {
     * LOGGER.info("方法 {} 停止执行", joinPoint.getSignature().getName()); return; }
     */
  }

}
