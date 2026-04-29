package com.example.demo.FormatIngredient;

import jakarta.validation.constraints.NotNull;

public class FormatIngredient {

    @NotNull
    private String titre;

    @NotNull
    private int quanite;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getQuanite() {
        return quanite;
    }

    public void setQuanite(int quanite) {
        this.quanite = quanite;
    }
}
