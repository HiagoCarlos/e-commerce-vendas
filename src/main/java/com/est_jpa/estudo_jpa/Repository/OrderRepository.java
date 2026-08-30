package com.est_jpa.estudo_jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.est_jpa.estudo_jpa.Entity.Order;
import java.util.UUID;


public interface OrderRepository  extends JpaRepository<Order, UUID> {
    
}
