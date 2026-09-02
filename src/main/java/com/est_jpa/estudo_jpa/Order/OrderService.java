package com.est_jpa.estudo_jpa.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrderService {

    
    private final OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(UUID id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
