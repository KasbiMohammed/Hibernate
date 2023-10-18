/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable 
public class ProduitCategoriePK implements Serializable{
    private int produit;
    private int categorie;

    public ProduitCategoriePK(int produit, int categorie) {
        this.produit = produit;
        this.categorie = categorie;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }
   
    
}
