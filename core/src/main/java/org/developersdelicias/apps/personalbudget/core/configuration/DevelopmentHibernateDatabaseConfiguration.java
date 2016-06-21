package org.developersdelicias.apps.personalbudget.core.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "org.developersdelicias.apps.personalbudget.core.model" })
@Profile("dev")
public class DevelopmentHibernateDatabaseConfiguration extends AbstractHibernateDatabaseConfiguration {
    private final static Logger _logger = LoggerFactory.getLogger(DevelopmentHibernateDatabaseConfiguration.class);

    @Override
    protected DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/personal_budget?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Override
    protected Properties hibernateProperties() {
        _logger.info("Creating Properties");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        _logger.info("Returning Properties");
        return properties;
    }
}
