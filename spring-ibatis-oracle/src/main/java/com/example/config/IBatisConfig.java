package com.example.config;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

@Configuration
public class IBatisConfig {

    @Bean
    public SqlMapClient sqlMapClient() throws Exception {
        SqlMapClientFactoryBean factoryBean = new SqlMapClientFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("sql-map-config.xml"));
        factoryBean.afterPropertiesSet();
        return (SqlMapClient) factoryBean.getObject();
    }
}