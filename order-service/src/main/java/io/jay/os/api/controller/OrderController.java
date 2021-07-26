package io.jay.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jay.os.api.common.Payment;
import io.jay.os.api.common.TransactionRequest;
import io.jay.os.api.common.TransactionResponse;
import io.jay.os.api.entity.Order;
import io.jay.os.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		return service.bookOrder(request);
	}
}
