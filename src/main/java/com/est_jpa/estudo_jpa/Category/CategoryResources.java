package com.est_jpa.estudo_jpa.Category;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable UUID id){
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category obj = categoryService.createCategory(category);
        return ResponseEntity.ok().body(obj);
    }

}
