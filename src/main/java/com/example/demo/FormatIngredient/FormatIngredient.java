package com.example.demo.FormatIngredient;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

public class FormatIngredient {

    @NotNull
    private String titre;

    @NotNull(message="ce champs est requis dans la demande")
    private Integer quantite;

    @AssertTrue(message="cet expression doit etre vrai")
    private boolean tester;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public boolean isTester() {
        return tester;
    }

    public void setTester(boolean tester) {
        this.tester = tester;
    }
}
