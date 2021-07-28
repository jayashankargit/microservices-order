package io.jay.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jay.ps.api.entity.Payment;
import io.jay.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired private PaymentRepository repository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}
	
	private String paymentStatus() {
		return new Random().nextBoolean() ? "success": "failure";
	}

	public Payment getPayment(int orderId) {
		return repository.findByOrderId(orderId);
	}
}
