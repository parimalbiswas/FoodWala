package com.foodwala.model;



import java.util.HashMap;
import java.util.Map;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

//	private Map<Item,Integer> itemList;

	@OneToOne
	private Customer customer;
	
	
	

}
