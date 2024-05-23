package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Restaurant;

public interface IRestaurantService {

	public List<Restaurant> showAll();

	public Restaurant FindById(Integer pRestaurant_Id);

	public void saveRestaurant(Restaurant pRestaurant);

	public void deleteRestaurant(Restaurant pRestaurant);
}
