package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;

public interface IFoodPlateService {
	public List<FoodPlate> showAll();

	public FoodPlate FindById(Integer pFoodPlate_Id);

	public void saveFoodPlate(FoodPlate pFoodPlate);

	public void deleteFoodPlate(FoodPlate pFoodPlate);
}
