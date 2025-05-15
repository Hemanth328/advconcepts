package com.org.multipledbconnections.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
                       basePackages = {"com.org.multipledbconnections.repository.user"},
                       transactionManagerRef = "transactionManager")
public class UserDBConfig {
    // As there are two databases, we are manually configuring the database configuration as there are two datasource's in the application.

    // Configuring the Datasource, we are informing which datasource the application should make use of
    @Primary // As we have two datasource's, we are making one as the primary datasource.
    @Bean("userDataSource")
    @ConfigurationProperties(prefix = "spring.user.datasource") // By giving the prefix, we are informing which properties(datasource) to use.
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("userDataSource") DataSource dataSource) {

        // As we are using Spring Data JPA, we want this program to create the database tables for us, for that we need to create the properties n they are
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        // This will create the entityManagerFactory bean.
        return entityManagerFactoryBuilder.dataSource(dataSource)
                .properties(properties) // this is added after creating the properties
                .packages("com.org.multipledbconnections.model.user")
                .persistenceUnit("userPersistenceUnit")
                .build();
    }

    @Primary
    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory")EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}

/*
As we are using Spring Data JPA, we need to make use of entityManagerFactory bean.

=> The @Qualifier annotation in Spring is used to resolve ambiguity when there are multiple beans of the same type, but you want to inject a specific one.

 */