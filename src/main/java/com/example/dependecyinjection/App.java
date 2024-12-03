package com.example.dependecyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.dependecyinjection.config.AppConfig;
import com.example.dependecyinjection.service.MyService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService service = context.getBean(MyService.class);
        service.performService();
        ((AnnotationConfigApplicationContext)context).close();
    }
}
