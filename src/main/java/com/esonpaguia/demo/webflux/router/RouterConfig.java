package com.esonpaguia.demo.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.esonpaguia.demo.webflux.handler.CustomerHandler;
import com.esonpaguia.demo.webflux.handler.CustomerHandlerStream;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerHandler handler;
	
	@Autowired
	private CustomerHandlerStream streamHandler;
	
	@Bean
	public RouterFunction<ServerResponse> routers() {
		return RouterFunctions.route()
				.GET("/router/customers", handler::getAllCustomers)
				.GET("/router/customers/stream", streamHandler::getAllCustomers)
				.GET("/router/customers/{id}", handler::getCustomer)
				.POST("/router/customers", handler::addCustomer)
				.build();
	}
	
}
