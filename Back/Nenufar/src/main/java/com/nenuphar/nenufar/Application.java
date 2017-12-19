package com.nenuphar.nenufar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Application
{
    public static void main(String[] args)
    {
        new SpringApplication(Application.class).run(args);
    }
}
