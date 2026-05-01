package com.example.demo.Controller;


import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Services.RecetteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class ControllerRecette {


    @Autowired
    private RecetteService recetteService;


    @PostMapping("/api/recettes")
    public ResponseEntity<?> AjouterRecette(@RequestBody @Valid FormatRecette recette1){
        if(!recetteService.existeparTitre(recette1.getTitre())){
            FormatRecette r1=recetteService.enregistrerRecette(recette1);
            return ResponseEntity.status(HttpStatus.CREATED).body(r1);
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("titre deja existant");
        }
    }



    @PutMapping("/api/recettes/{id}")
    public ResponseEntity<?> ModifierRecette(@PathVariable int id,@RequestBody FormatRecette recette){
        if(recetteService.existe(id)){
            recetteService.modifierRecette(id,recette);
            return ResponseEntity.noContent().build();
        }else {
           return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/api/recettes/{id}")
    public ResponseEntity<Void> SupprimerRecette(@PathVariable int id){
         if(recetteService.existe(id)){
             recetteService.SupprimerRecette(id);
             return ResponseEntity.noContent().build();
         }else {
             return ResponseEntity.notFound().build();
         }
    }


    @GetMapping("/api/recettes/{id}")
    public ResponseEntity<FormatRecette> Consulter(@PathVariable int id){
        FormatRecette r1=recetteService.chercher(id);
        if (r1== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(r1);
    }



}
