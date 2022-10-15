package com.example.retos345.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos345.entities.Farm;

public interface FarmRepository  extends JpaRepository<Farm, Integer>{
}
