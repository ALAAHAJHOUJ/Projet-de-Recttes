package com.example.demo.Controller;


import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Services.IngredientService;
import com.example.demo.Services.RecetteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerRecette {


    @Autowired
    private RecetteService recetteService;


    @PostMapping("/api/recettes")
    public String tester(@RequestBody @Valid FormatRecette recette1){

        System.out.println(recette1.getListIngredient().get(0).getQuanite());
        recetteService.enregistrerRecette(recette1);
        return "string";
    }
}
