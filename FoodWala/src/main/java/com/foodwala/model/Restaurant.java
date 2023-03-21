package com.foodwala.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Restaurant
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rest_Id;

	private String rest_name;

	@OneToOne
	private Address rest_address;

	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "restaurant")
	private List<Item> items = new ArrayList<>();

	private String manager_name;

	private String contact_name;

}
