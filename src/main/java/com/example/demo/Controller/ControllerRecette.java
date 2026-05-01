package com.example.demo.Controller;


import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Services.RecetteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerRecette {


    @Autowired
    private RecetteService recetteService;


    @PostMapping("/api/recettes")
    public String AjouterRecette(@RequestBody @Valid FormatRecette recette1){

        recetteService.enregistrerRecette(recette1);
        return "string";
    }

    @PutMapping("/api/recettes/{id}")
    public String ModifierRecette(@PathVariable int id,@RequestBody FormatRecette recette){
        recetteService.modifierRecette(id,recette);
        return "modification avec succes";
    }


    @DeleteMapping("/api/recettes/{id}")
    public String SupprimerRecette(@PathVariable int id){
        recetteService.SupprimerRecette(id);
        return "suppression avec succes";
    }


    @GetMapping("/api/recettes/{id}")
    public String Consulter(@PathVariable int id){
        FormatRecette r1=recetteService.chercher(id);
        return "string";
    }



}
