package com.stussy.stussyClone20220929seunghwan.aop;


import com.stussy.stussyClone20220929seunghwan.dto.CMRespDto;
import com.stussy.stussyClone20220929seunghwan.dto.account.RegisterReqDto;
import com.stussy.stussyClone20220929seunghwan.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ValidationAop {

    @Pointcut("@annotation(com.stussy.stussyClone20220929seunghwan.aop.annotation.ValidAspect)")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
//                log.info("asdf : {}", bindingResult);
                break;
            }
        }

//        if(bindingResult == null) {
//            return joinPoint.proceed();  // proceed : 전처리 -> (proceed) -> 후처리
//        }

        if (bindingResult.hasErrors()) {
//            log.error("유효성 검사 오류 발생");
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            throw new CustomValidationException("Validation failed", errorMap);  // 강제로 예외 발생
        }
    }
    @AfterReturning(value = "pointcut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        log.info("Validation success: {}", returnObj);
    }
}
