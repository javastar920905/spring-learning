/**
 * Created by ouzhx on 2017/11/17.
 * xml 配置切面
 * <aop:aspectj:autoproxy proxy-target-class="true"></>
 *
 * //切面
 * <bean id="logAspect"  class="xxx"></bean>
 *
 * <aop:config>
     //定义切面 ref
     <aop:aspect ref="logAspect">
           //定义切点(切入点),具体的方法声明
           <aop:pointcut expression="excution(* com.ouzhx.service..*(..))" id="logPointcut"></aop:pointcut>
           //定义如何触发通知 (监听pointcut-ref规则的所有方法,执行了则触发通知(通知类型:区分前后通知(执行切点方法前)))
           <aop:before method="before" pointcut-ref="logPointcut"></aop:before>
           <aop:after-returning method="afterReturn" returning="返回指定值类型才通知" pointcut-ref="logPointcut"></aop:after-returning>
           <aop:after method="after" pointcut-ref="logPointcut"></aop:after>
           <aop:after-throwing method="whenException" pointcut-ref="logPointcut"></aop:after-throwing>
     </aop:aspect>
 * </aop:config>
 **/
package com.ouzhx.aspect;
