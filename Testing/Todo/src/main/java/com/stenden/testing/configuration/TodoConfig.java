package com.stenden.testing.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ron on 15/12/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.stenden.testing")
public class TodoConfig {
}
