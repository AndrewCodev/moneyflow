package com.drewcode.moneyflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drewcode.moneyflow.entity.Category;
import com.drewcode.moneyflow.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category update(Category category) {
        return repository.getReferenceById(category.getId());
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category no found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
