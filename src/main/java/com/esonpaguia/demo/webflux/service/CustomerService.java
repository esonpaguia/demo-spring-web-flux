package com.esonpaguia.demo.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esonpaguia.demo.webflux.dao.CustomerDao;
import com.esonpaguia.demo.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public List<Customer> getAllCustomers() {
		long start = System.currentTimeMillis();
		List<Customer> list = dao.getAllCustomers();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time: " + (end - start));
		return list;
	}

	public Flux<Customer> getAllCustomersStream() {
		long start = System.currentTimeMillis();
		Flux<Customer> list = dao.getAllCustomersStream();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time: " + (end - start));
		return list;
	}
	
}
