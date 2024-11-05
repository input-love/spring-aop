package andrew.samardak.spring_aop.aspect;

import andrew.samardak.spring_aop.entity.DataSourceErrorLog;
import andrew.samardak.spring_aop.service.LogDataSourceErrorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogDataSourceErrorAspect {

    LogDataSourceErrorService service;

    @Pointcut("execution(* (@LogDataSourceError *).*(..))")
    public void methodsInAnnotatedClass() {
    }

    @AfterThrowing(
            pointcut = "methodsInAnnotatedClass()",
            throwing = "ex"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        DataSourceErrorLog entity = DataSourceErrorLog.builder()
                .stackTrace(Arrays.toString(ex.getStackTrace()))
                .message(ex.getMessage())
                .methodSignature(joinPoint.getSignature().toLongString()).build();

        service.create(entity);
    }
}
