package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>  {

}
