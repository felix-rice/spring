package com.felix.spring.base.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-11
 */
@Aspect
@Component
public class AddProxy {
    private static final Logger log = Logger.getLogger(AddProxy.class.getName());
    // 前置通知
    @Before(value = "execution(* com.felix.spring.base.aop.Add.add(..))")
    public void before() {
        log.info("aop before ...");
    }
    // 后置通知
    @After(value = "execution(* com.felix.spring.base.aop.Add.add(..))")
    public void after() {
        log.info("aop after ...");
    }
    // 环绕通知
    @Around(value = "execution(* com.felix.spring.base.aop.Add.add(..))")
    public int around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aop around before ...");
        int ret = (int) proceedingJoinPoint.proceed();
        log.info("aop around after ...");
        return ret;
    }
    // 异常通知
    @AfterThrowing(value = "execution(* com.felix.spring.base.aop.Add.add(..))")
    public void afterThrowing() {
        log.info("aop after throwing ...");
    }
    // 最终通知
    @AfterReturning(value = "execution(* com.felix.spring.base.aop.Add.add(..))")
    public void afterReturning() {
        log.info("aop after returning ...");
    }
}
