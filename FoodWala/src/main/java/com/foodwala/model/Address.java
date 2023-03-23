package com.foodwala.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String buildingName;

	private String streetNo;

	private String area;

	private String city;

	private String State;

	private String pincode;

//	@OneToOne(mappedBy = "address")
//	private Customer customer;
//
//    @OneToOne(mappedBy="rest_address")
//	private Restaurant restaurant;

}
