package com.example.retos345.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos345.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}
