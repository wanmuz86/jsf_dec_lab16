package com.example.dependecyinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MyService {
	
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
		System.out.println("Service is performed using repository");
	}

	
}
