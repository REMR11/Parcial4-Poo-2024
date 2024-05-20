package com.parcialpoo.ufg.MR100823.models;

import java.time.LocalTime;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 * clase que representa una reservación
 * */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "RESERVATION")
public class Reservation {

	/**
	 * Identificador único de la reservación.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservation_Id;
	
	/**
	 * Fecha y hora de la reservación.
	 */
	private LocalTime reservation_date;
	
	/**
	 * Precio total de la reservación.
	 */
	@Column(nullable = false, precision = 10)
	private float total_price;
	
	/**
	 * Estado de la reservación.
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	/**
	 * Cliente asociado a la reservación.
	 */
	@ManyToOne
	@JoinColumn(name="costumer_Id")
	private Costumer costumer;
	@Override
	public int hashCode() {
		return Objects.hash(costumer, reservation_Id, reservation_date, status, total_price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(costumer, other.costumer) && Objects.equals(reservation_Id, other.reservation_Id)
				&& Objects.equals(reservation_date, other.reservation_date) && status == other.status
				&& Float.floatToIntBits(total_price) == Float.floatToIntBits(other.total_price);
	}
	
	/**
	 * Enum que representa los diferentes estados de una reservación.
	 */
	public enum Status {
		PENDING, CONFIRMED, CANCELLED
	}
}
