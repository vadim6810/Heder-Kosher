package com.tel_ran.hederkosher.configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Igor on 03.08.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tel_ran.hederkosher")
public class HKConfig {

}
