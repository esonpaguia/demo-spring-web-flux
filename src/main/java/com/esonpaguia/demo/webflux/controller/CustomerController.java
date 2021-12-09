package com.esonpaguia.demo.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esonpaguia.demo.webflux.dto.Customer;
import com.esonpaguia.demo.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@GetMapping(value="/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomersStream() {
		return service.getAllCustomersStream();
	}
	
}
