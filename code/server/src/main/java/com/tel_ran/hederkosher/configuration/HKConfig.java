package com.tel_ran.hederkosher.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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

}
