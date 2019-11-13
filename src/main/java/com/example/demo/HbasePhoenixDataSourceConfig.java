package com.example.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 *@Aurhor dulijun
 */
@Configuration
@PropertySource(value= "classpath:application.properties")
@MapperScan(basePackages = HbasePhoenixDataSourceConfig.PACKAGE,sqlSessionFactoryRef = HbasePhoenixDataSourceConfig.HBASEPHOENIX_SQL_SESSION_FACTORY)
public class HbasePhoenixDataSourceConfig {
    static final String HBASEPHOENIX_SQL_SESSION_FACTORY = "hbasePhoenixSqlSessionFactory";
    static final String PACKAGE = "com.example.demo.phoenix.entity";
    static final String MAPPER_LOCATION = "mapper/*Mapper.xml";

    @Value("${spring.datasource.url}")
    private String url;


    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "hbasePhoenixDataSource")
    public DataSource hbasePhoenixDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean(name = "hbasePhoenixTransactionManager")
    public DataSourceTransactionManager hbasePhoenixTransactionManager(@Qualifier("hbasePhoenixDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = HBASEPHOENIX_SQL_SESSION_FACTORY)
    public SqlSessionFactory hbasePhoenixSqlSessionFactory(@Qualifier("hbasePhoenixDataSource") DataSource hbasePhoenixDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hbasePhoenixDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(HbasePhoenixDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

