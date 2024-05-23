package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.TableRestaurant;

public interface ITableRestaurantService {

	public List<TableRestaurant> showAll();

	public TableRestaurant FindById(Integer pTableRestaurant_Id);

	public void saveTableRestaurant(TableRestaurant pTableRestaurant);

	public void deleteTableRestaurant(TableRestaurant pTableRestaurant);
}
