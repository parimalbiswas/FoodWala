package com.foodwala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.CustomerException;
import com.foodwala.model.Address;
import com.foodwala.model.Customer;
import com.foodwala.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	public CustomerRepo cRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException
	{
		Customer c = cRepo.findByMobileNumber(customer.getMobileNumber());
		if (c == null)
		{
			Customer newCustomer = cRepo.save(customer);
			return newCustomer;
		}
		else
		{
			throw new CustomerException("You are already registered");
		}

	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer customer) throws CustomerException
	{
		Optional<Customer> cust = cRepo.findById(customerId);

		if (cust.isPresent())
		{
			Customer updated = cust.get();

			updated.setFirstName(customer.getFirstName());
			updated.setLastName(customer.getLastName());
			updated.setEmail(customer.getEmail());
			updated.setMobileNumber(customer.getMobileNumber());
			updated.setPassword(customer.getMobileNumber());

			Address add = new Address();

			add.setBuildingName(customer.getAddress().getBuildingName());
			add.setArea(customer.getAddress().getArea());
			add.setCity(customer.getAddress().getCity());
			add.setPincode(customer.getAddress().getPincode());
			add.setStreetNo(customer.getAddress().getStreetNo());
			add.setState(customer.getAddress().getState());

			updated.setAddress(add);

			cRepo.save(updated);
			return updated;

		}
		else
		{
			throw new CustomerException("Nothing found with this id");
		}
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException
	{
		Optional<Customer> cust = cRepo.findById(customerId);

		if (cust.isPresent())
		{
			Customer deletedcustomer = cust.get();

			cRepo.delete(deletedcustomer);

			return deletedcustomer;

		}
		else
		{
			throw new CustomerException("Nothing found with this id");
		}

	}


	@Override
	public Customer getcustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> cust=cRepo.findById(customerId);
		
		if(cust.isPresent())
		{
			Customer customer=cust.get();
			
//			customer.getFirstName();
//			customer.getLastName();
//			customer.getMobileNumber();
			
			return customer;
			
		}
		else
		{
			throw new CustomerException("Nothing found with this id");
		}
	}


	@Override
	public Integer TotalNumberOfCustomerRegistered() {
		List<Customer> registered=cRepo.findAll();
		
		return registered.size();
		
	}


	
}
