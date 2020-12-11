package org.lby.meiqia.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.lby.meiqia.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(org.lby.meiqia.common.annotation.WebLog)")
    public void webLog() {
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
         //接收到请求，记录请求内容
         ServletRequestAttributes attributes = (ServletRequestAttributes)
         RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         //记录下请求内容
         LOGGER.info("URL : " + request.getRequestURL().toString());
         LOGGER.info("HTTP_METHOD : " + request.getMethod());
         LOGGER.info("IP : " + request.getRemoteAddr());
         LOGGER.info("CLASS_METHOD : " +
         joinPoint.getSignature().getDeclaringTypeName() + "."
         + joinPoint.getSignature().getName());
        LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
         LOGGER.info("RESPONSE : " + JsonUtils.toString(ret));
        LOGGER.info("SPEND TIME : "
                + (System.currentTimeMillis() - startTime.get()) + "ms");
        startTime.remove();// 用完之后记得清除，不然可能导致内存泄露;
    }
}
