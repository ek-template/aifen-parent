package com.aifen.aspect;


import cn.hutool.core.util.NetUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Title ManageAopLog
 * @Author     qierkang xyqierkang@163.com
 * @Date       Created in 2019-03-31 13:03
 * @Description [ Manage系统aop日志监控 ]
 */
@Aspect
@Component
@Slf4j
public class ManageAopLog {

    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.aifen.controller..*.*(..))")
    public void log() {

    }

    /**
     * 前置操作
     *
     * @param point 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        // 记录下请求内容
        log.info("-------------------begin-----------------------------");
        log.info("url   : {}", request.getRequestURL().toString());
        String method = request.getMethod();
        log.info("method: {}", method);
        log.info("ip    : {}>是否本地局域网 {}", NetUtil.getLocalhostStr(),NetUtil.isInnerIP(NetUtil.getLocalhostStr()));
        String queryString = request.getQueryString();
        String params = "";
//        Enumeration enu = request.getParameterNames();

        Object[] args = point.getArgs();
        if (args.length > 0) {
            if ("POST".equals(method)) {
                Object object = args[0];
                Map map = getKeyAndValue(object);
                params = JSON.toJSONString(map);
            } else if ("GET".equals(method)) {
                params = queryString;
            }
        }
        log.info("params : {}", params);

    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
//    @Around("log()")
//    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
//        Object result = point.proceed();
//        log.info("【返回值】：{}", JSONObject.fromObject(result));
//        return result;
//    }

    /**
     * 后置操作
     */
    @After("log()")
    public void afterReturning() throws Throwable {
        log.info("-------------------end-----------------------------");
    }

    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            // 设置些属性是可以访问的
            f.setAccessible(true);
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                // 设置键值
                map.put(f.getName(), val);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        if (map.containsKey("serialVersionUID")) {
            map.remove("serialVersionUID");
        }
        return map;
    }

}
