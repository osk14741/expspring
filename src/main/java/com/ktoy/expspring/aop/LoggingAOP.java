package com.ktoy.expspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAOP {

    // Around -> Before -> () -> After -> Around
    @Around("execution(* com.ktoy.expspring..*Controller.*(..)) || execution(* com.ktoy.expspring..*Handler.*(..))")
    public Object logMethodName(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        StopWatch sw = new StopWatch();
        sw.start();
        String beforeString = "START===="
                + className
                + "."
                + methodName
                + "====START";
        log.info(beforeString);
        Object result = pjp.proceed();
        sw.stop();
        long executionTime = sw.getTotalTimeMillis();
        log.info("[EXECUTION TIME] " + executionTime + " ms");
        String afterString = "END======"
                + className
                + "."
                + methodName
                + "======END";
        log.info(afterString);



        return result;
    }

//    @Before("execution(* com.ktoy.expspring..*.*(..))")
    public void beforeAOP(JoinPoint joinPoint) throws Throwable{
        log.info("========BEFORE AOP========");
    }

//    @After("execution(* com.ktoy.expspring..*.*(..))")
    public void afterAOP(JoinPoint joinPoint) throws Throwable{
        log.info("========AFTER AOP========");
    }
}
