package com.est_jpa.estudo_jpa.Category;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categorys")
public class CategoryResources {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
       List<Category> list = categoryService.getAllCategories();

        return ResponseEntity.ok().body(list);
    }
    
   

    
}
