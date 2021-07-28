package io.jay.ps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jay.ps.api.entity.Payment;
import io.jay.ps.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired private PaymentService service;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return service.doPayment(payment);
	}
	
	//api gateway check
	@GetMapping("/{orderId}")
	public Payment getPayment(@PathVariable int orderId) {
		return service.getPayment(orderId);
	}
	
}
