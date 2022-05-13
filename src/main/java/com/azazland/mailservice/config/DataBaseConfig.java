package com.azazland.mailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

    @Bean("entityManagerFactory")
    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
        LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        localEntityManagerFactoryBean.setPersistenceUnitName("mailService");
        return localEntityManagerFactoryBean;
    }
}*/
