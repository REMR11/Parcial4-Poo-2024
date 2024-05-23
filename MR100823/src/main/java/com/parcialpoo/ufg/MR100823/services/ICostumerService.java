package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Costumer;

public interface ICostumerService {
	public List<Costumer> showAll();
	
	public Costumer FindById(Integer pCostumer_Id);
	
	public void saveCostumer(Costumer pCoscutmer);
	
	public void deleteCostumer(Costumer pCostumer);
}
