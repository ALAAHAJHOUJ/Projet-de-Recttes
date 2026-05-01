package com.example.demo.Repository;

import com.example.demo.entites.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ingredientRepo extends JpaRepository<Ingredient,Integer> {

    public void deleteByNom(String Nom);
}
