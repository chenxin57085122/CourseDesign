package com.xinyuan.main.bean;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * @Auther: chenxin
 * @Date: 2018/12/24 11:36
 * @Description:
 */
@Configuration
public class DataSourceConfig {

   @Autowired
    private Environment env = null;
    @Bean
    public DataSource getDataSourece(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("com.mysql.jdbc.Driver"));
        return dataSource;
    }
}
