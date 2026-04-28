package com.example.demo.Repository;

import com.example.demo.entites.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ingredientRepo extends JpaRepository<Ingredient,Integer> {
}
