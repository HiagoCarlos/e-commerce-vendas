package com.est_jpa.estudo_jpa.Order;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderResources {

    private final OrderService orderService;

    @GetMapping 
    public ResponseEntity<List<Order>> findAll() {
       List<Order> list = orderService.findAll();

        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable UUID id){
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
