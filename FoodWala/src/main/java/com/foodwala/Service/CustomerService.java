package com.foodwala.service;

import com.foodwala.exception.CustomerException;
import com.foodwala.model.Customer;

public interface CustomerService
{

	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Integer customerId, Customer customer) throws CustomerException;

	public Customer deleteCustomer(Integer customerId) throws CustomerException;
}
