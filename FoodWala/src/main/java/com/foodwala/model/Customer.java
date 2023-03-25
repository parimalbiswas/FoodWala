package com.foodwala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_id;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	private String email;

	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

}
