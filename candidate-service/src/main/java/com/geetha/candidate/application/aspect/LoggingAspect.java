package com.geetha.candidate.application.aspect;

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

    @Pointcut("execution(public * com.geetha.candidate.application.controller..*.*(..))")
    public void controllerMethods(){}

    @Pointcut("execution(public * com.geetha.candidate.domain.service..*.*(..))")
    public void serviceMethods(){}

    @Before("controllerMethods() || serviceMethods()")
    public void logMethodStart(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] input = joinPoint.getArgs();
        log.info("Executing {}.{} for input {}",className,method,input);
    }
}