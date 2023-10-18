/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProduitCategorie {
    @EmbeddedId
    private ProduitCategoriePK ;
    private int quantite;
      @ManyToOne 
      @JoinColumn(name = "produit",insertable = false,updatable = false) 
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "categorie",insertable = false,updatable = false)
    private Categorie categorie;

    public ProduitCategorie() {
    }

    public ProduitCategorie(ProduitCategoriePK pk, int quantite, Produit produit, Categorie categorie) {
        this.pk = pk;
        this.quantite = quantite;
        this.produit = produit;
        this.categorie = categorie;
    }

    public ProduitCategoriePK getPk() {
        return pk;
    }

    public void setPk(ProduitCategoriePK pk) {
        this.pk = pk;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
}
