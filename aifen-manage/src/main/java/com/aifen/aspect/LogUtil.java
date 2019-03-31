package com.aifen.aspect;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* @author qierkang xyqierkang@163.com
* @Title: LogUtil.java
* @date 2019-03-06
* @Description: [ 日志输出工具类 ]
*/
@Component
public class LogUtil {

    protected static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void pushLog(String remarks, String med, String req, String token) throws Exception{
        logger.info( "EK>系统日志：[{}]方法名[{}]参数[{}]操作人[{}]操作时间[{}]",
                remarks,med,req, token, DateUtil.date());
    }

    public static void pushErrorLog(String remarks, String med, String req, String token,String errorMes)throws Exception{
        logger.info( "EK>系统服务异常日志：[{}]方法名[{}]参数[{}]操作人[{}]操作时间[{}]错误信息[{}]",
                remarks,med,req, token, DateUtil.date(),errorMes);
    }
}
