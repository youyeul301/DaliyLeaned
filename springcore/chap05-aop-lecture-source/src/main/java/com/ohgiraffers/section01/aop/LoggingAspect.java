package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Objects;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggingAspect {

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointCut(){}

    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before joinPoint,getTarget() : "+joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : "+joinPoint.getSignature());
        if (joinPoint.getArgs().length>0){
            for (Object param : joinPoint.getArgs()){
                System.out.println(param);
            }
        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getSignature() : "+joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "logPointCut()",returning = "result")
    public void logAfterReturning (JoinPoint joinPoint , Object result){
        System.out.println("after returning result : "+result);
    }

    @AfterThrowing(pointcut = "logPointCut()",throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("exception message :"+exception.getMessage());
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        //사전에 동작할 내용
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object result=joinPoint.proceed();

        //사후에 동작할 내용
        stopWatch.stop();
        System.out.println("메소드 수행에 걸린 시간 : "+stopWatch.getTotalTimeMillis());
        return result;
    }
}


