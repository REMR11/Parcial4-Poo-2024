package com.parcialpoo.ufg.MR100823.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "TABLE")
public class Table {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int table_Id;
	
	@Column(length = 2)
	private int capacity;
	
	@Column(length = 200)
	private  String description;
	
	@Column(length = 20)
	private String topic;
	
	private boolean status; 
	
	
	@ManyToOne
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;
	
}
