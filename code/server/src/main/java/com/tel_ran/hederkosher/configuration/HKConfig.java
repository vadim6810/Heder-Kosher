package com.tel_ran.hederkosher.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Igor on 03.08.2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tel_ran.hederkosher.*")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class HKConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("pass").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("pass").roles("USER");
    }

}
