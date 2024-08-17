package com.jc.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void greetingLoggerPointCut(){}

    @Pointcut("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void greetingFooLoggerPointCut(){}
}
