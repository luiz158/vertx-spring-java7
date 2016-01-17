package com.leosilvadev.components;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leosilvadev.components.counter.CounterVerticle;

import io.vertx.core.Vertx;

@Configuration
public class VertxApplication {

	@Bean
	public Vertx vertx(){
		return Vertx.factory.vertx();
	}
	
	@PostConstruct
	public void deployVerticles(){
		vertx().deployVerticle(CounterVerticle.class.getName());
	}
	
}
