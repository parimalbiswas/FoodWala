package com.foodwala.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.Repository.CustomerRepo;
import com.foodwala.exception.CustomerException;
import com.foodwala.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerRepo cRepo;
	
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer c=cRepo.findByMobileNumber(customer.getMobileNumber());
		if(c==null)
		{
			Customer newCustomer = cRepo.save(customer);
			return newCustomer;
		} else {
			throw new CustomerException("You are already registered");
		}
		
	}
}
	
	
	


