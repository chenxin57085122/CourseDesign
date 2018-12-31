package com.xinyuan.main.bean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Auther: chenxin
 * @Date: 2018/12/24 12:58
 * @Description:
 */
@Configuration
@MapperScan(basePackages = MyBatisConfig.MAPPER_PACKAGE)
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

    public static final String MAPPER_PACKAGE = "com.xinyuan.main.dao";
    public static final String MAPPER_XML_PACKAGE = "classpath:mapper/*";
    public static final String MAPPER_BEAN_PACKAGE = "com.xinyuan.mapper.domain";

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置扫描mybatis-cofig.xml
        sqlSessionFactoryBean.setConfigLocation(null);
        //设置扫描mapper.xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(MAPPER_XML_PACKAGE);
        sqlSessionFactoryBean.setMapperLocations(resources);
        //设置扫描实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(MAPPER_BEAN_PACKAGE);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
