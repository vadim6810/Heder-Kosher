package com.tel_ran.hederkosher.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@EnableWebMvc
@ComponentScan(basePackages = "com.tel_ran.hederkosher.*")
public class HKConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {

    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) {
            try {
                http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    }

    @Configuration
    class AppConfig extends WebMvcConfigurerAdapter {

        /* Here we register the Hibernate5Module into an ObjectMapper,
         * then set this custom-configured ObjectMapper
         * to the MessageConverter and return it to be added to the HttpMessageConverters
         * of our application
         */
        public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
            MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

            ObjectMapper mapper = new ObjectMapper();
            //Registering Hibernate5Module to support lazy objects
            mapper.registerModule(new Hibernate5Module());

            messageConverter.setObjectMapper(mapper);
            return messageConverter;

        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            //Here we add our custom-configured HttpMessageConverter
            converters.add(jacksonMessageConverter());
            super.configureMessageConverters(converters);
        }

    }

    @Configuration
    @EnableTransactionManagement
    @PropertySource("classpath:hibernate.properties")
    class PersistenceContextConfiguration {

        private static final String PROPERTY_NAME_DATABASE_DRIVER = "hibernate.connection.driver_class";
        private static final String PROPERTY_NAME_DATABASE_PASSWORD = "hibernate.connection.password";
        private static final String PROPERTY_NAME_DATABASE_URL = "hibernate.connection.url";
        private static final String PROPERTY_NAME_DATABASE_USERNAME = "hibernate.connection.username";

        private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
        private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
        private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
        private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";

        @Resource
        private Environment env;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
            dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
            dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
            dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
            return dataSource;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(dataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan(
                    "com.tel_ran.hederkosher.model.security.entity",
                    "com.tel_ran.hederkosher.model.common.entity"
            );

            entityManagerFactoryBean.setJpaProperties(hibProperties());

            entityManagerFactoryBean.setPersistenceUnitName("HKSpringHibernate");

            return entityManagerFactoryBean;
        }

        private Properties hibProperties() {
            Properties properties = new Properties();
            properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
            properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
            properties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
            properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
            return properties;
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }


//        @Bean
//        public LocalPersistenceManagerFactoryBean persistensManagerFactory() {
//            LocalPersistenceManagerFactoryBean persistensManagerFactoryBean = new LocalPersistenceManagerFactoryBean();
//            persistensManagerFactoryBean.setConfigLocation("hibernate.properties");
//
//            return persistensManagerFactoryBean;
//        }
//


    }

}
