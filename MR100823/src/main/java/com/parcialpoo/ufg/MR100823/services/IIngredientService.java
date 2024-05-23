package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Ingredient;

public interface IIngredientService {
	
	public List<Ingredient> showAll();

	public Ingredient FindById(Integer pIngredient_Id);

	public void saveIngredient(Ingredient pIngredient);

	public void deleteIngredient(Ingredient pIngredient);
}
