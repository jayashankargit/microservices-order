package io.jay.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jay.os.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
