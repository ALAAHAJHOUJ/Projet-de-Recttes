package com.example.demo.FormatIngredient;

import jakarta.validation.constraints.NotNull;

public class FormatIngredient {

    @NotNull
    private String titre;

    @NotNull(message="ce champs est requis dans la demande")
    private int quantite;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getQuanite() {
        return quantite;
    }

    public void setQuanite(int quantite) {
        this.quantite = quantite;
    }
}
