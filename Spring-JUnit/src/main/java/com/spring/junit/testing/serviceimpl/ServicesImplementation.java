package com.spring.junit.testing.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.junit.testing.entity.Customer;
import com.spring.junit.testing.exception.CustomException;
import com.spring.junit.testing.repository.CustomerRepository;
import com.spring.junit.testing.service.Services;

@Service
public class ServicesImplementation implements Services {

	@Autowired
	private CustomerRepository customerRepository;
	
	public ServicesImplementation(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> displayAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public ResponseEntity<Optional<Customer>> displayCustomerById(int id) throws CustomException{
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isEmpty())
			throw new CustomException("No Customer with id "+id+" present!!");
		else
		return ResponseEntity.ok(customer);
	}

}
