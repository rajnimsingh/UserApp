package com.rajni.userservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.rajni.userservice..*(..))")
    public Object applyAspect(ProceedingJoinPoint joinpoint) throws Throwable {
        final MethodSignature signature = (MethodSignature) joinpoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();

        String methodName = signature.getName();
        System.out.println("In " + className + " , entering " + methodName);
        final Object result = joinpoint.proceed();

        System.out.println("Exiting " + className + " , entering " + methodName + ", with result = " + result);
        return result;
    }
}
