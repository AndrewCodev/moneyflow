package com.drewcode.moneyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drewcode.moneyflow.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
