package com.est_jpa.estudo_jpa.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.est_jpa.estudo_jpa.Product;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>{
    
}
