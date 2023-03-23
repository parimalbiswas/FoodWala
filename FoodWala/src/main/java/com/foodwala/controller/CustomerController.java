package com.foodwala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.CustomerException;
import com.foodwala.model.Customer;
import com.foodwala.service.CustomerService;

@RestController
@RequestMapping("api/customer/")
public class CustomerController
{

	@Autowired
	public CustomerService cservice;

	@PostMapping("add")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException
	{
		Customer newcustomer = cservice.addCustomer(customer);

		return new ResponseEntity<Customer>(newcustomer, HttpStatus.CREATED);
	}

	@PutMapping("update/{cusId}")
	public ResponseEntity<Customer> updatecuatomerhandler(@PathVariable Integer cusId, @RequestBody Customer customer)
			throws CustomerException
	{
		Customer updated = cservice.updateCustomer(cusId, customer);

		return new ResponseEntity<Customer>(updated, HttpStatus.OK);
	}

	@DeleteMapping("delete/{cusId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer cusId) throws CustomerException
	{
		Customer deletedCustomer = cservice.deleteCustomer(cusId);
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
	
	@GetMapping("get/{cusId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer cusId) throws CustomerException
	{
		Customer Customer=cservice.getcustomerById(cusId);
		return new ResponseEntity<Customer>(Customer,HttpStatus.OK);
	}
	@GetMapping("totalCustomer")
	public ResponseEntity<Integer> TotalNumberOfCustomer() throws CustomerException
	{
		Integer total=cservice.TotalNumberOfCustomerRegistered();
		return new ResponseEntity<Integer>(total,HttpStatus.OK);
	}
}
