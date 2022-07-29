package com.ktoy.expspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAOP {

    @Around("execution(* com.ktoy.expspring..*.*(..))")
    public Object logMethodName(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        StopWatch sw = new StopWatch();
        sw.start();
        log.info("===================================================================================================");
        log.info("[CONTROLLER LOCATION] " + className + "." + methodName);
        // 현재 로그인 된 유저도 적어보자.
        Object result = pjp.proceed();
        sw.stop();
        long executionTime = sw.getTotalTimeMillis();
        log.info("[EXECUTION TIME] " + executionTime + " ms");
        log.info("===================================================================================================");

        return result;
    }
}