package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Payment;

public interface IPaymentService {

	public List<Payment> showAll();

	public Payment FindById(Integer pPayment_Id);

	public void savePayment(Payment pPayment);

}
