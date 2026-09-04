package com.est_jpa.estudo_jpa.Product;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.est_jpa.estudo_jpa.Category.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String imgURL;

    @Setter(AccessLevel.NONE)
    private Set<Category> categories = new HashSet<>();

    

    public Product() {
    }
    
    public  Product(String name, String email, String descrString, Double  price, String imgURL){
        super();
        this.name = name;
        this.email = email;
        this.description = descrString;
        this.price = price;
        this.imgURL = imgURL;
    }
    

}