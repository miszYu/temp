package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//JdbcTemplate DataSource Configuration
@Configuration
public class JdbcTemplateConfiguration {

    // 連線到 test1 資料庫的 DataSource 和 NamedParameterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1")
    public NamedParameterJdbcTemplate test1JdbcTemplate(
            @Qualifier("test1DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    // 連線到 test2 資料庫的 DataSource 和 NamedParameterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2")
    public NamedParameterJdbcTemplate test2JdbcTemplate(
            @Qualifier("test2DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    // 連線到 myjdbc 資料庫的 DataSource 和 NamedParameterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.myjdbc")
    public DataSource myjdbcDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public NamedParameterJdbcTemplate myjdbcJdbcTemplate(
            @Qualifier("myjdbcDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    // 連線到 myjpa 資料庫的 DataSource 和 NamedParameterJdbcTemplate
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.myjpa")
//    public DataSource myjpaDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "myjpa")
//    public NamedParameterJdbcTemplate myjpaJdbcTemplate(
//            @Qualifier("myjpaDataSource") DataSource dataSource) {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }


}