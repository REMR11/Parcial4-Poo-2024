package com.parcialpoo.ufg.MR100823.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;

public interface FoodPlateRepository extends JpaRepository<FoodPlate, Integer>{
	
}
