package com.drewcode.moneyflow.service;

import java.util.List;

import com.drewcode.moneyflow.entity.Category;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

    Category update(Category category);

    com.drewcode.moneyflow.entity.Category findById(Long id);

    void deleteById(Long id);
}
