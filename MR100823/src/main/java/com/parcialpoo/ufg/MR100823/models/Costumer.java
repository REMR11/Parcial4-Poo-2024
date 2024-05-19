package com.parcialpoo.ufg.MR100823.models;

import java.util.List;
import java.util.Objects;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "COSTUMER")
public class Costumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer costumer_Id;
	
	private String name;
	
	private String email;
	private String password;
	@Column(length = 11)
	private Integer phone;
	
	@OneToMany(mappedBy = "costumer")
	private List<Reservation> reservaciones;

	@Override
	public int hashCode() {
		return Objects.hash(costumer_Id, email, name, password, phone, reservaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		return Objects.equals(costumer_Id, other.costumer_Id) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(reservaciones, other.reservaciones);
	}
	
}
