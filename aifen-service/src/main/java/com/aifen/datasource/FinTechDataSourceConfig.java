package com.aifen.datasource;

import com.aifen.datasource.druid.DruidDataSources;
import com.aifen.enumerator.ConstantInterface;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.aifen.dao", sqlSessionFactoryRef = "fintechSqlSessionFactory")
public class FinTechDataSourceConfig {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DataBean dataBean;

    @Bean(name = "fintechDataSource")
    @Primary
    public DataSource csDataSource() {
        return DruidDataSources.getDataSource(dataBean.getDriver(), dataBean.getDbUrl(), dataBean.getDbUserName(), dataBean.getDbPassword());
    }

    @Bean(name = "fintechTransactionManager")
    @Primary
    public DataSourceTransactionManager csTransactionManager() {
        return new DataSourceTransactionManager(csDataSource());
    }


    @Bean(name = "fintechSqlSessionFactory")
    @Primary
    public MybatisSqlSessionFactoryBean csSqlSessionFactory(@Qualifier("fintechDataSource") DataSource masterDataSource)
            throws Exception {
        final MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(masterDataSource);
        Resource[] r1 = new PathMatchingResourcePatternResolver().getResources(ConstantInterface.DruidDataConfig.DRUIDDATA_CONFIG.PROCEDURE_MAPPER.getValue());
        Resource[] r2 = new PathMatchingResourcePatternResolver().getResources(ConstantInterface.DruidDataConfig.DRUIDDATA_CONFIG.FINTECH_MAPPER.getValue());
        Resource[] r3 = ArrayUtils.addAll(r1, r2);
        bean.setMapperLocations(r3);
        return bean;
    }

}
