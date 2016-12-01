package ir.hri.aspect;

import ir.hri.aspect.annotation.Loggable;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger("jerseyApp");

    @AfterThrowing(
            pointcut = "execution(* *(..)) && @annotation(loggable))",
            throwing = "ex"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Loggable loggable, Throwable ex) {
        String packageName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.error("description: " + loggable.description() + ";\n " +
                "packageName: " + packageName + ";\n " +
                "methodName: " + methodName + ":\n" +
                "ex: " + ex);
    }

    @Around("execution(* *(..)) &&  @annotation(loggable)")
    public Object executionTime(ProceedingJoinPoint pjp,
                                Loggable loggable) throws Throwable {

        String packageName = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        logger.info("description: " + loggable.description() + ";\n " +
                "packageName: " + packageName + ";\n " +
                "methodName: " + methodName);
        Object result = pjp.proceed();

        return result;
    }
}