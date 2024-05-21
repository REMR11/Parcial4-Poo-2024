package com.parcialpoo.ufg.MR100823.models;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;
	
	@OneToOne(mappedBy = "order")
	private Costumer costumer;
	
	@OneToMany(mappedBy = "order")
	private List<FoodPlate> plates;
	
	@Column(nullable = false)
	private Time orderDate;

	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private float totalPrice;

	/**
	 * @return the order_Id
	 */
	public int getOrder_Id() {
		return order_Id;
	}

	/**
	 * @param order_Id the order_Id to set
	 */
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	/**
	 * @return the costumer
	 */
	public Costumer getCostumer() {
		return costumer;
	}

	/**
	 * @param costumer the costumer to set
	 */
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	/**
	 * @return the plates
	 */
	public List<FoodPlate> getPlates() {
		return plates;
	}

	/**
	 * @param plates the plates to set
	 */
	public void setPlates(List<FoodPlate> plates) {
		this.plates = plates;
	}

	/**
	 * @return the orderDate
	 */
	public Time getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Time orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	/**
	 * Enum que representa los diferentes estados de una orden.
	 */
	public enum Status {
		PENDING, PREPARING, READY, DELIVRED
	}

}
