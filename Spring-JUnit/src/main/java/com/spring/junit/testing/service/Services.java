package com.spring.junit.testing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.spring.junit.testing.entity.Customer;
import com.spring.junit.testing.exception.CustomException;

public interface Services {

	public List<Customer> displayAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	public ResponseEntity<Optional<Customer>> displayCustomerById(int id)throws CustomException;
}
