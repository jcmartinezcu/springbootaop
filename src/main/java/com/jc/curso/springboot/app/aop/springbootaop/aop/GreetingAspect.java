package com.jc.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    @Around("execution(* com.jc.curso.springboot.app.aop.springbootaop.service.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("El metodo " + method + "() con los parmetros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {
           
            logger.error("Error en la llamada del metodo "+  method + "()");
            throw e;
        }
       
    }

}
