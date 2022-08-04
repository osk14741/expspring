package com.ktoy.expspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAOP {

    // Around -> Before -> () -> After -> Around
    @Around("execution(* com.ktoy.expspring..*Controller.*(..)) " +
            "|| execution(* com.ktoy.expspring..*Handler.*(..))")
    public Object logMethodName(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        Object[] signatureArgs = pjp.getArgs();
        StopWatch sw = new StopWatch();
        sw.start();
        String beforeString = "START================" + className + "." + methodName + "=====================";
        log.info(beforeString);
        Object result = pjp.proceed();

        for (int i = 0; i < signatureArgs.length; i++) {
            log.info("|| PARAM : " + signatureArgs[i].toString());
        }
        if(null != result) log.info("|| RETURN : " + result);

        sw.stop();
        long executionTime = sw.getTotalTimeMillis();
        log.info("|| EXECUTION TIME : " + executionTime + " ms");
        String afterString = "END==================" + className + "." + methodName + "=====================";
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
