package com.example.demo.Repository;

import com.example.demo.entites.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecetteRepo extends JpaRepository<Recette,Integer> {

    public Recette findByTitre(String titre);
}
