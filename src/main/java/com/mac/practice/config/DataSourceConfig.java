package com.mac.practice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Profile("!test")
@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {


    @Bean
    @ConditionalOnExpression(value = "${spring.datasource.postgres.enabled:false}")
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @ConditionalOnExpression(
            "${spring.datasource.postgres.enabled:false} AND ${spring.datasource.postgres.jdbc.enabled:false}")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

//    @Bean
////    @ConfigurationProperties("spring.datasource.hikari")
//    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
//
//        LocalContainerEntityManagerFactoryBean localContainerEntityManager = new LocalContainerEntityManagerFactoryBean();
//
//        localContainerEntityManager.setDataSource(dataSource);
//        localContainerEntityManager.setPackagesToScan("com.mac.practice");
//        localContainerEntityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//    }

}
