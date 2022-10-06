package com.stussy.stussyClone20220929seunghwan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
*  메소드 실행 시간을 계산해주는 로직
*/

@Slf4j
@Aspect
@Component  // IoC에 등록하기위한 어노테이션
public class TimerAop {

    @Pointcut("execution(* com.stussy.stussyClone20220929seunghwan.controller.*.*(..))")
    private void executionPointCut() {}

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable {
                                          // joinPoint는 실행되는 메소드의 정보를 담는다.
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();  // 실행 전 후 기준점, 메소드에 리턴이 있는 경우 result를 가져온다.


        stopWatch.stop();
        log.info("class: {}, method: {} >>> {}",                    // getSignature : class 정보를 담는다.
                joinPoint.getSignature().getDeclaringTypeName(),    // TypeName : 클래스 명
                joinPoint.getSignature().getName(),                 // getName : 메소드 명
                stopWatch.getTotalTimeSeconds());

        return result;

    }

}
