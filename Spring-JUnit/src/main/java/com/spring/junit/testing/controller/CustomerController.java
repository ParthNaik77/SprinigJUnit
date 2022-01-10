package com.spring.junit.testing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.junit.testing.entity.Customer;
import com.spring.junit.testing.service.Services;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private Services service;

	public CustomerController(Services service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAllCustomers")
	public @ResponseBody List<Customer> getAllCustomers() {
		return service.displayAllCustomers();
	}
	
	@PostMapping("/createCustomer")
	public Customer postCustomer(@RequestBody Customer customer) {
		return service.createCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int id) {
		return service.displayCustomerById(id);
	}
}
