package com.ktoy.expspring.aop;

import com.ktoy.expspring.common.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static com.ktoy.expspring.common.StaticUtil.llc;
import static com.ktoy.expspring.common.StaticUtil.lls;


@Aspect
@Component
@Slf4j
public class LoggingAOP {
    static boolean flagFromAOP = false;
    @Around("execution(* com.ktoy.expspring..*Service.*(..))")
    public Object logService(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().getClass().getSimpleName();
        String realClassName = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] signatureArgs = pjp.getArgs();
        StopWatch sw = new StopWatch();

        if(flagFromAOP) log.info("|| ");

        sw.start();
        String beforeString;
        if(flagFromAOP) beforeString = "|| SERVICE START===="+className + "." + methodName;
        else beforeString = "   SERVICE START===="+className + "." + methodName;

        int beforeStringLength = 150 - beforeString.length();
        for (int i = 0; i < beforeStringLength; i++) {
            beforeString += "=";
        }
        int lengthOfBeforeString = beforeString.length();
        log.info(beforeString);
        Object result = pjp.proceed();

        HttpServletRequest servletRequest = (
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()
        ).getRequest();

        if(lls.size() > 0){
            if(flagFromAOP){
                log.info("|| ||==== USER LOGGING");
                for (Object obj : lls) {
                    log.info("|| || " + obj);
                }
                log.info("|| ||==== USER LOGGING");
                log.info("|| ||");
            } else {
                log.info("   ||==== USER LOGGING");
                for (Object obj : lls) {
                    log.info("   || " + obj);
                }
                log.info("   ||==== USER LOGGING");
                log.info("   ||");
            }
            lls.clear();

        }

        int sub;
        String param;
        for (int i = 0; i < signatureArgs.length; i++) {
            if(flagFromAOP) param = "|| || <== PARAM : " + signatureArgs[i].toString();
            else param = "   || <== PARAM : " + signatureArgs[i].toString();
            sub = lengthOfBeforeString - param.length();
            if(sub > 0){
                for(int j = 0; j < sub - 2; j++){
                    param += " ";
                }
            }
            log.info(param);
        }

        String resultString;
        if (result != null) {
            if(flagFromAOP) resultString = "|| || ==> RETURN : " + result;
            else resultString = "   || ==> RETURN : " + result;
            sub = lengthOfBeforeString - resultString.length();
            if (sub > 0) {
                for (int i = 0; i < sub - 2; i++) {
                    resultString += " ";
                }
            }
            log.info(resultString);
        }

        sw.stop();
        long executionTime = sw.getTotalTimeMillis();
        String mils = String.valueOf(executionTime);
        if(flagFromAOP) mils = "|| || EXECUTION TIME : " + mils + " ms";
        else mils = "   || EXECUTION TIME : " + mils + " ms";
        sub = lengthOfBeforeString - mils.length();
        if (sub > 0) {
            for (int i = 0; i < sub - 2; i++) {
                mils += " ";
            }
        }
        log.info(mils);
        String afterString;
        if(flagFromAOP) afterString = "|| SERVICE END======" + className + "." + methodName;
        else afterString = "   SERVICE END======" + className + "." + methodName;
        int afterStringLength = 150 - afterString.length();
        for (int i = 0; i < afterStringLength; i++) {
            afterString += "=";
        }

        log.info(afterString);
        if(flagFromAOP) log.info("|| ");
        else log.info(" ");
        return result;
    }

    // Around -> Before -> () -> After -> Around
    @Around("execution(* com.ktoy.expspring..*Controller.*(..)) " +
            "|| execution(* com.ktoy.expspring..*Handler.*(..))")
    public Object logMethodName(ProceedingJoinPoint pjp) throws Throwable{
        flagFromAOP = true;
        String className = pjp.getTarget().getClass().getSimpleName();
        String realClassName = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] signatureArgs = pjp.getArgs();
        StopWatch sw = new StopWatch();

        sw.start();
        String beforeString = "START===="+className + "." + methodName;
        int beforeStringLength = 150 - beforeString.length();
        for (int i = 0; i < beforeStringLength; i++) {
            beforeString += "=";
        }
        int lengthOfBeforeString = beforeString.length();
        log.info(beforeString);
        Object result = pjp.proceed();

        HttpServletRequest servletRequest = (
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()
        ).getRequest();

        if(llc.size() > 0){
            log.info("||==== USER LOGGING");
            for(Object obj : llc){
                log.info("|| " + obj);
            }
            log.info("||==== USER LOGGING");
            llc.clear();
            log.info("||");
        }

        int sub;
        String username;
        try{
            username = (String) servletRequest.getSession().getAttribute("username");
        } catch(Exception e){username = null;}

        if(username != null) username = "|| USERNAME : " + username + " (SIGN IN)";
        else username = "|| USERNAME : NULL (SIGN OUT)";

        sub = lengthOfBeforeString - username.length();
        if( sub > 0){
            for(int i = 0; i < sub - 2; i++){
                username += " ";
            }
        }
        log.info(username);

        String param;
        for (int i = 0; i < signatureArgs.length; i++) {
            param = "|| <== PARAM : " + signatureArgs[i].toString();
            sub = lengthOfBeforeString - param.length();
            if(sub > 0){
                for(int j = 0; j < sub - 2; j++){
                    param += " ";
                }
            }
            log.info(param);
        }


        String resultString;
        if (result != null) {
            resultString = "|| ==> RETURN : " + result;
            sub = lengthOfBeforeString - resultString.length();
            if (sub > 0) {
                for (int i = 0; i < sub - 2; i++) {
                    resultString += " ";
                }
            }
            log.info(resultString);
        }

        sw.stop();
        long executionTime = sw.getTotalTimeMillis();
        String mils = String.valueOf(executionTime);
        mils = "|| EXECUTION TIME : " + mils + " ms";
        sub = lengthOfBeforeString - mils.length();
        if (sub > 0) {
            for (int i = 0; i < sub - 2; i++) {
                mils += " ";
            }
        }
        log.info(mils);

        String afterString = "END======" + className + "." + methodName;
        int afterStringLength = 150 - afterString.length();
        for (int i = 0; i < afterStringLength; i++) {
            afterString += "=";
        }

        log.info(afterString);
        flagFromAOP = false;
        log.info(" ");
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
