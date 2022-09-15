package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.dto.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer>{

}
