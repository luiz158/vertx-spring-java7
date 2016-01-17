package com.leosilvadev.components.counter;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

@Component
public class CounterVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		vertx.eventBus().consumer("vertx.counter.sum", new Handler<Message<JsonObject>>() {
			public void handle(final Message<JsonObject> message) {
				JsonObject object = message.body();
				final Double result = new Values(object.getDouble("valueOne"), object.getDouble("valueTwo")).sum();
				
				//Simulation of hard processing...
				vertx.setTimer(5000, new Handler<Long>() {
					public void handle(Long l) {
						message.reply(result);
					}
				});
				
			}
		});
	}
	
}
