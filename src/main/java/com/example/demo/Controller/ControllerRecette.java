package com.example.demo.Controller;


import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Pagination.PagedResponse;
import com.example.demo.Services.RecetteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


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
    public ResponseEntity<?> Consulter(@PathVariable int id){
        boolean exister=recetteService.existe(id);
        if (!exister) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        FormatRecette r1=recetteService.chercher(id);
        return ResponseEntity.status(HttpStatus.OK).body(r1);
    }



    @GetMapping("/pagination/")
    public ResponseEntity<PagedResponse<FormatRecette>> tester(){
        Page<FormatRecette> Recettes1=recetteService.RecettePagine1(0,2);
        List<FormatRecette> RecettesRespone=new LinkedList<>();

        Recettes1.forEach((recette)->{
            FormatRecette recette2=new FormatRecette();
            BeanUtils.copyProperties(recette,recette2);
            RecettesRespone.add(recette2);
        });

        PagedResponse<FormatRecette> PagedResponse=new PagedResponse<>(Recettes1.getTotalPages()
                ,Recettes1.getSize()
                ,Recettes1.getTotalElements()
                ,Recettes1.getNumber()+1
                ,RecettesRespone

        );
        return ResponseEntity.status(HttpStatus.OK).body(PagedResponse);
    }



    @GetMapping("/pagination2/")
    public Page<FormatRecette> tester111(){
         return recetteService.chercher1("tajin");
    }



}
