package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.dto.item;

public interface itemRepository extends JpaRepository<item, Integer> {

}
