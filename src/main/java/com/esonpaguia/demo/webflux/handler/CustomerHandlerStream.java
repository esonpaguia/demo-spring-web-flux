package com.esonpaguia.demo.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.esonpaguia.demo.webflux.dao.CustomerDao;
import com.esonpaguia.demo.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandlerStream {

	@Autowired
	private CustomerDao dao;
	
	public Mono<ServerResponse> getAllCustomers(ServerRequest request) {
		Flux<Customer> list = dao.getAllCustomersStream();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(list, Customer.class);
	}
	
}