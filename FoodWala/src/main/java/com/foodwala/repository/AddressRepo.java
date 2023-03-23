package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwala.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	

}
