package com.stackroute.index.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(AOPLogger.class);
	
	@Around("execution(* com.stackroute.index.controller.Controller.getCS())")
    public Object around(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Object object = point.proceed();
		
        logger.info("AOP Logger is working");
        logger.info("for map = "+object + " time taken "+(System.currentTimeMillis()-start));
        
        return object;
    }
}
