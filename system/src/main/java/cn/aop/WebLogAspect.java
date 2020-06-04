package cn.aop;

import cn.entity.SysLog;
import cn.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    @Resource
    SysLogService sysLogService;

    @Pointcut("execution(public * cn.controller..*.*(..)) && !execution(public * cn.controller..OrderInfoController.flushCancelOrderStatus(..))")//切入点
    public void controllerRoleLog(){}//签名  切入点名称

    @Pointcut("execution(public * cn.controller..*.*(..)) && !execution(public * cn.controller..OrderInfoController.flushCancelOrderStatus(..))")
    public void controllerUserLog(){}
//   || controllerUserLog()

    @Before("controllerRoleLog() || controllerUserLog() ") //在切入点run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        MyLog myLog=method.getAnnotation(MyLog.class);
        SysLog sysLog=new SysLog();
        sysLog.setUserNo(111);
        sysLog.setGmtCreate(new Date());
        sysLog.setRealName("用户");
        sysLog.setIp(GetIp.getIpAddress(request));
        sysLog.setMethod(request.getMethod());
        sysLog.setPath(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        sysLog.setContent(Arrays.toString(joinPoint.getArgs()));
        sysLog.setOperation(":::");
        // 记录下请求内容
        if(myLog!=null){
            logger.info("################Operation"+myLog.value());
            sysLog.setOperation(myLog.value());
        }
        logger.info("################URL : " + request.getRequestURL().toString());//请求url
        logger.info("################HTTP_METHOD : " + request.getMethod());//提交方式
        logger.info("################IP : " + GetIp.getIpAddress(request));//ip地址
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));//参数

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("###############"+new Date());

        sysLogService.insert(sysLog);
    }
}
