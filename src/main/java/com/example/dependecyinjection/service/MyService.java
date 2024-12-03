package com.example.dependecyinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MyService {
	
	// Retrieve the value user.name of the system [PC] #{} ->spEL
	// Inject it to the variable userName
	@Value("#{systemProperties['user.name']}")
	private String userName;
	
	@Value("${app.name}") // Retieving value in Java 
	private String appName;
	
	// spEL retrieve and perform operation
	// #{} -> I can perform operation
	// ${} -> Retrieve the value app.isProd from config file
	// ? : -> Ternary operator/ simplified if else
	//if  app.isProd == true {'stable version'} else 'Test Version'
	@Value("#{${app.isProd} ? 'Stable version' : 'Test version'}")
	private String appMessage;
	
	@Autowired
	private final MyRepository repository;
	
	public MyService(MyRepository repository) {
		this.repository = repository;
	}
	
	// Spring will ensure that the injected component is initialized
	// Before injection
	// In this case, repository will be created first
	// Then injected to MyService
	
	@PostConstruct
	public void init() {
		System.out.println("MyService has been initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("MyService is going to be destroyed");
	}
	
	public void performService() {
		System.out.println("Service is performed using repository by "+userName);
		repository.sayHello();
		System.out.println("Application Name: " + appName);
		System.out.println(appMessage);

	}

	
}
