package com.est_jpa.estudo_jpa.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface OrderRepository  extends JpaRepository<Order, UUID> {
    
}
