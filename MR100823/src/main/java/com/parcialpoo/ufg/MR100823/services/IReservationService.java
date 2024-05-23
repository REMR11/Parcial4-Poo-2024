package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Reservation;

public interface IReservationService {

	public List<Reservation> showAll();

	public Reservation FindById(Integer pReservation_Id);

	public void saveReservation(Reservation pReservation);

	public void deleteReservation(Reservation pReservation);
}
