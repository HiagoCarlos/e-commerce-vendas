package com.est_jpa.estudo_jpa.Product;

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
@RequestMapping(value = "/products")
public class ProductResources{

    private final ProductRepository productRepository;

    @GetMapping 
    public ResponseEntity<List<Product>> findAll() {
       List<Product> list = productRepository.findAll();

        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id){
        Product obj = productRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(obj);
    }
}

