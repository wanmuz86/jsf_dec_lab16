package com.example.dependecyinjection.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example.dependecyinjection.service")
public class AppConfig {

}
