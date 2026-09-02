package com.est_jpa.estudo_jpa.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category findById(UUID id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
