package com.turdiev.spHmvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyLoggingAspect {


    @Around("execution(* com.turdiev.spHmvc.dao.*.*(..))")
    public Object aroundAllRepositoryMithodsAdvice (ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


        MethodSignature signature =(MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = signature.getName();

        System.out.println("Beging of " + methodName );

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName );

        return  targetMethodResult;
    }

}
