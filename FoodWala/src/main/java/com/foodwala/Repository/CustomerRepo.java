package com.foodwala.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwala.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	

}
