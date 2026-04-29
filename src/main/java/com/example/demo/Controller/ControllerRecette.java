package com.example.demo.Controller;


import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Repository.RecetteRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerRecette {


    @Autowired
    private RecetteRepo recetteRepo;

    @PostMapping("/api/recettes")
    public String tester(@RequestBody @Valid FormatRecette recette1){
       System.out.println("okkk");
       return "string";
    }
}
