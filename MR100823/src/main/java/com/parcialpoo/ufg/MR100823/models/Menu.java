package com.parcialpoo.ufg.MR100823.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_Id;
	
	@Column(length = 60)
	private String name;
	
	@Column(length = 255)
	private String description;
	
	private int price;
}
