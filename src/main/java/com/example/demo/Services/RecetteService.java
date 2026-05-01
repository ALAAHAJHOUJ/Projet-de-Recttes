package com.example.demo.Services;

import com.example.demo.FormatIngredient.FormatIngredient;
import com.example.demo.FormatRecette.FormatRecette;
import com.example.demo.Repository.RecetteRepo;
import com.example.demo.entites.Ingredient;
import com.example.demo.entites.Recette;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class RecetteService {


    @Autowired
    private RecetteRepo recetteRepo;

    @Autowired
    private IngredientService ingredientService;


    public String enregistrerRecette(FormatRecette recette){
        Recette r1=new Recette();
        BeanUtils.copyProperties(recette,r1);

        List<Ingredient> ingredient1=recette.getListIngredient().stream().map(iDto -> {
                    Ingredient i = new Ingredient();
                    i.setQuantite(iDto.getQuantite());
                    i.setNom(iDto.getNom());
                    i.setRecette(r1);
                    return i;
                })
                .toList();

        r1.setIngredients(ingredient1);
        System.out.println(r1.getIngredients().get(0).getNom()+r1.getIngredients().get(0).getQuantite());

        recetteRepo.save(r1);

        return "verified";
    }



    public String modifierRecette(int id, FormatRecette recette){
        Recette r1=recetteRepo.findById(id).orElseThrow(()->new RuntimeException("recette inexistante"));

        if(recette.getTitre()!=null){
             r1.setTitre(recette.getTitre());
        }

        if(recette.getDescription()!=null){
             r1.setDescription(recette.getDescription());
        }

        if(recette.getLink_Img()!=null){
             r1.setLink_Img(recette.getLink_Img());
        }

        if(recette.getTempsMinutes()!=null){
           r1.setTempsMinutes(recette.getTempsMinutes());
        }

        if(recette.getListIngredient()!=null){
            List<Ingredient> listIngr=new LinkedList<>();
            //d'abord on supprime tous les recettes
            for(Ingredient r:r1.getIngredients()){
                String titreIngr=r.getNom();
                ingredientService.supprimerIngredient(titreIngr,id);
            }

            //ajouter Les roucettes envoyés dans la demande
            for(FormatIngredient d:recette.getListIngredient()){
                Ingredient ingr1=new Ingredient();
                ingr1.setNom(d.getNom());
                ingr1.setRecette(r1);
                ingr1.setQuantite(d.getQuantite());
                listIngr.add(ingr1);
            }
            r1.setIngredients(listIngr);
        }

        recetteRepo.save(r1);



        return "succes";
    }



    public String  SupprimerRecette(int id){
        Recette r1=recetteRepo.findById(id).orElseThrow(()->new RuntimeException("recette inexistante"));

        recetteRepo.delete(r1);
        return "suppression avec succes";
    }



    public FormatRecette chercher(int id){
        Recette r1=recetteRepo.findById(id).orElseThrow(()->new RuntimeException("recette introuvable"));
        FormatRecette format=new FormatRecette();
        BeanUtils.copyProperties(r1,format);
        return format;
    }
}
