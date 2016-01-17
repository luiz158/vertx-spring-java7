package com.leosilvadev.counter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

@RestController
@RequestMapping("/counter/sum")
public class CounterController {
	
	@Autowired
	Vertx vertx;
	
	@RequestMapping("/{valueOne}/{valueTwo}")
	public void sumOf(@PathVariable Double valueOne, @PathVariable Double valueTwo){
		JsonObject json = new JsonObject().put("valueOne", valueOne).put("valueTwo", valueTwo);
		
		vertx.eventBus().send("vertx.counter.sum", json, new Handler<AsyncResult<Message<Double>>>() {
			public void handle(AsyncResult<Message<Double>> message) {
				System.out.println(message.result().body());
			}
		});
	}

}
