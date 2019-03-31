package com.aifen.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author qierkang xyqierkang@163.com
 * @Title: DruidDataSources.java
 * @Package com.fintech.dao.datasource
 * @date 2018年6月7日 上午3:29:23
 * @Description: TODO[ 用一句话描述该文件做什么 ]
 */
public class DruidDataSources {

    /**
     * @param @param  driverClass
     * @param @param  url
     * @param @param  user
     * @param @param  password
     * @param @return 设定文件
     *
     * @throws
     * @Title: DruidDataSources.java
     * @author qierkang xyqierkang@163.com
     * @date 2018年6月7日 上午3:29:24
     * @Description: TODO[ 这里用一句话描述这个方法的作用 ]
     */
    public static DataSource getDataSource(String driverClass, String url, String user, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        try {
            dataSource.setFilters("config");
            Properties properties = new Properties();
            properties.setProperty("druid.stat.slowSqlMillis", "5000");
//	            properties.setProperty("config.decrypt","true");
//	            properties.setProperty("config.decrypt.key",publicKey);
            dataSource.setConnectProperties(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
