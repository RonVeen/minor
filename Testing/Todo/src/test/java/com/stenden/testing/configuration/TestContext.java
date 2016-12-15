package com.stenden.testing.configuration;

import com.stenden.testing.service.TodoService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ron on 15/12/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.stenden.testing.controller")
public class TestContext {

    @Bean
    public TodoService todoService() {
        return Mockito.mock(TodoService.class);
    }
}
