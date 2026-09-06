package com.est_jpa.estudo_jpa.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
     private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(UUID id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
