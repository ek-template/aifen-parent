package com.aifen.datasource;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Title DataBean
 * @Author     qierkang xyqierkang@163.com
 * @Date       Created in 2019-03-30 21:50
 * @Description [ 数据库dataBean ]
 */
@Data
@Component
public class DataBean {
    private static final Logger logger = LoggerFactory.getLogger(DataBean.class);

    @PostConstruct
    public void init() {
        logger.info("EK 初始化properties配置文件[{}] >执行spring初始化PostConstruct操作时间[{}]", tetsProperties, DateUtil.today());
        logger.info("EK 初始化yml配置文件[{}] >执行spring初始化PostConstruct操作时间[{}]", testYml, DateUtil.today());
    }

    @Value("${this.properties}")
    private String tetsProperties;
    @Value("${thisyml}")
    private String testYml;
    @Value("${dbUrl}")
    private String dbUrl;
    @Value("${dbUserName}")
    private String dbUserName;
    @Value("${dbPassword}")
    private String dbPassword;
    @Value("${driver}")
    private String driver;


}
