package com.spring.junit.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.junit.testing.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
