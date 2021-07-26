package io.jay.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.jay.os.api.common.Payment;
import io.jay.os.api.common.TransactionRequest;
import io.jay.os.api.common.TransactionResponse;
import io.jay.os.api.entity.Order;
import io.jay.os.api.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired private OrderRepository repository;
	@Autowired private RestTemplate restTemplate;
	@Value("${payment-microservice-name}") private String paymentMicroServiceName;
	
	public TransactionResponse bookOrder(TransactionRequest request) {
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		// make a rest call to save it in payment table also
		Payment paymentResponse = restTemplate.postForObject(paymentMicroServiceName + "/payment/doPayment", payment, Payment.class);
		String message = paymentResponse.getPaymentStatus().equals("success") ? "payment success and order placed" : "payment failed and order added in cart";
		Order orderResponse = repository.save(order);
		return new TransactionResponse(orderResponse, paymentResponse.getTransactionId(), paymentResponse.getAmount(), message);
	}
}
