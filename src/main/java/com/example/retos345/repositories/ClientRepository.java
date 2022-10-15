package com.example.retos345.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos345.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
}
