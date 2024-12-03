package com.example.dependecyinjection.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MyRepository {
	
	public MyRepository() {
		System.out.println("Repository created");
	}
	
	@PostConstruct
	public void init () {
		System.out.println("Post repository creation");
	
	}
	
	// MyService, which has been injected with MyRepository
	// Will destroy itself first
	// Before destroying / removing MyRepository
	
	@PreDestroy
	public void destroy() {
		System.out.println("Repository will be destroyted");
	}

}
