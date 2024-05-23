package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.OrderCostumer;

public interface IOrderCostumerService {

	public List<OrderCostumer> showAll();

	public OrderCostumer FindById(Integer pOrderCostumer_Id);

	public void saveOrderCostumer(OrderCostumer pOrderCostumer);

	public void deleteOrderCostumer(OrderCostumer pOrderCostumer);
}
