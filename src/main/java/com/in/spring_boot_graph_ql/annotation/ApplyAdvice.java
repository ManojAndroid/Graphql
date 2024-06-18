package com.in.spring_boot_graph_ql.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@Aspect
@Component
@Slf4j
@Data
public class ApplyAdvice {
    //reference link https://www.youtube.com/watch?v=gGb3ClYlgc0
    @Around("@annotation(com.in.spring_boot_graph_ql.annotation.LogTime)")
    public Object LogTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " starts at" + start);
        Object object = proceedingJoinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " end at" + end);
        log.info("Method :" + proceedingJoinPoint.getSignature().getName() + " Took total time :{} milliseconds"
                , (end.get(ChronoField.MILLI_OF_SECOND) - start.get(ChronoField.MILLI_OF_SECOND)));
        return object;
    }

    @Around("@annotation(com.in.spring_boot_graph_ql.annotation.LogRequest)")
    public Object LogRequest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() +
                " with request " + mapper.writeValueAsString(proceedingJoinPoint.getArgs()));
        return proceedingJoinPoint.proceed();
    }

    @Around("@annotation(com.in.spring_boot_graph_ql.annotation.LogResponse)")
    public Object LogResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        Object oj = proceedingJoinPoint.proceed();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() +
                " with response " + mapper.writeValueAsString(oj));
        return oj;
    }

    @Around("@annotation(com.in.spring_boot_graph_ql.annotation.LogRequestResponseAndTime)")
    public Object LogRequestResponseAndTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " starts at" + start);
        ObjectMapper mapper = new ObjectMapper();
        // logging request
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " with request " + mapper.writeValueAsString(proceedingJoinPoint.getArgs()));
        Object object = proceedingJoinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " end at" + end);
        log.info("Method :" + proceedingJoinPoint.getSignature().getName() + " Took total time :{} milliseconds"
                , (end.get(ChronoField.MILLI_OF_SECOND) - start.get(ChronoField.MILLI_OF_SECOND)));
        //logging response
        log.info("In method " + proceedingJoinPoint.getSignature().getName() + " with response " + mapper.writeValueAsString(object));
        return object;
    }
}
