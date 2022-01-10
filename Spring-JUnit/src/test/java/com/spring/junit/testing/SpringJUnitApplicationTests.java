package com.spring.junit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.junit.testing.entity.Customer;
import com.spring.junit.testing.repository.CustomerRepository;
import com.spring.junit.testing.serviceimpl.ServicesImplementation;

@SpringBootTest
class SpringJUnitApplicationTests {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServicesImplementation serviceImplementation;
	
	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(101,"Parth Naik", "Male", 22, "Veg"),
				new Customer(102,"Vishal Pund", "Male", 23, "Non-Veg")).collect(Collectors.toList()));
		assertEquals(2, ( serviceImplementation.displayAllCustomers()).size()); 
	}
	
	@Test
	public void addCustomerTest() {
		Customer customer=new Customer(101, "Parth Naik", "Male", 22, "Veg"); 
		when(customerRepository.save(customer)).thenReturn(customer); 
		assertEquals(customer, serviceImplementation.createCustomer(customer));
	}

}
