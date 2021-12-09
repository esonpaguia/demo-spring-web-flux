package com.esonpaguia.demo.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.esonpaguia.demo.webflux.dao.CustomerDao;
import com.esonpaguia.demo.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	@Autowired
	private CustomerDao dao;
	
	public Mono<ServerResponse> getAllCustomers(ServerRequest request) {
		Flux<Customer> list = dao.getCustomersList();
		return ServerResponse.ok().body(list, Customer.class);
	}
	
	public Mono<ServerResponse> getCustomer(ServerRequest request) {
		int customerId = Integer.valueOf(request.pathVariable("id"));
		Mono<Customer> customer = dao.getCustomersList().filter(c -> c.getId() == customerId).next();
		return ServerResponse.ok().body(customer, Customer.class);
	}
	
	public Mono<ServerResponse> addCustomer(ServerRequest request) {
		Mono<Customer> customer = request.bodyToMono(Customer.class);
		Mono<String> saveResponse = customer.map(c -> "customer " + c.getId());
		return ServerResponse.ok().body(saveResponse, String.class);
	}
	
}
