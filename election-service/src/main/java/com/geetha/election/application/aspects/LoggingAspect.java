package com.geetha.election.application.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

//    @Pointcut("execution(public * *(..))") // Provides logs for all including spring framework classes
    @Pointcut("execution(public * com.geetha.election.application.controller..*.*(..))")
    public void controllerMethods(){}

    @Pointcut("execution(public * com.geetha.election.domain.service..*.*(..))")
    public void serviceMethods(){}

    @Before("controllerMethods() || serviceMethods()")
    public void logMethodStart(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] input = joinPoint.getArgs();
        log.info("Executing {}.{} with input => {}",className,method,input);
    }
}