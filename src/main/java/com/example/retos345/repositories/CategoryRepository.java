package com.example.retos345.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos345.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}
