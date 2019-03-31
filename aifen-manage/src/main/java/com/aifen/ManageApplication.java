package com.aifen;

import com.aifen.properties.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @Title ManageApplication
 * @Author     qierkang xyqierkang@163.com
 * @Date       Created in 2019-03-30 15:17
 * @Description [ boot入口启动类 ]
 */
@SuppressWarnings("SpringBootApplicationSetup")
@ServletComponentScan //开启servlet注解ServletConfigure
@SpringBootApplication(scanBasePackages = "com.aifen")//等同于 @Configuration @EnableAutoConfiguration @ComponentScan
@PropertySource(value = {"classpath:jdbc.properties","classpath:service.yml"},ignoreResourceNotFound = true)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ManageApplication implements EmbeddedServletContainerCustomizer {

    @Autowired
    private TestConfig testConfig;
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

    /**
     * 自定义端口
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container){
        container.setPort(testConfig.getPort());
    }
}
