package com.example.demo.Services;

import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Repository.RecetteRepo;
import com.example.demo.entites.Ingredient;
import com.example.demo.entites.Recette;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecetteService {


    @Autowired
    private RecetteRepo recetteRepo;



    public String enregistrerRecette(FormatRecette recette){
        Recette r1=new Recette();
        BeanUtils.copyProperties(recette,r1);

        List<Ingredient> ingredient1=recette.getListIngredient().stream().map(iDto -> {
                    Ingredient i = new Ingredient();
                    i.setQuantite(iDto.getQuantite());
                    i.setNom(iDto.getTitre());
                    i.setRecette(r1);
                    return i;
                })
                .toList();

        r1.setIngredients(ingredient1);
        System.out.println(r1.getIngredients().get(0).getNom()+r1.getIngredients().get(0).getQuantite());

        recetteRepo.save(r1);

        return "verified";
    }
}
