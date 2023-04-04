package com.foodwala.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billId;

	private Integer totalItem;
	
	private Integer totalCost;
	
//	@OneToOne
//	private Order order;
	
	private LocalDateTime time;
}
