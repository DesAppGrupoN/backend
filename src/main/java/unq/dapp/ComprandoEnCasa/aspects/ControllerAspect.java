package unq.dapp.ComprandoEnCasa.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class ControllerAspect {

    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("execution(* unq.dapp.ComprandoEnCasa.webService.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        long initialTime = System.currentTimeMillis();
        String controllerName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - initialTime;

        logger.info("----------------------------------------------");
        logger.info("Controller: " + controllerName);
        logger.info("Method: " + methodName);
        logger.info("Execution time: " + executionTime);

        return proceed;
    }
}
