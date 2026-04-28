package com.example.demo.Repository;

import com.example.demo.entites.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepo extends JpaRepository<Recette,Integer> {
}
