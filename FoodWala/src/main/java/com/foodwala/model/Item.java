package com.foodwala.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer item_Id;

	private String item_names;

	@OneToOne(cascade = CascadeType.ALL)
	private Category rest_category;


	private Integer quentity;

	private Double cost;

	@ManyToOne(cascade = CascadeType.DETACH)
	private Restaurant restaurant;

}
