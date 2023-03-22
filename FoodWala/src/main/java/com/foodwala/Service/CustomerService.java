package com.foodwala.Service;

import com.foodwala.exception.CustomerException;
import com.foodwala.model.Customer;

public interface CustomerService {
	

	public Customer addCustomer(Customer customer) throws CustomerException;
}
