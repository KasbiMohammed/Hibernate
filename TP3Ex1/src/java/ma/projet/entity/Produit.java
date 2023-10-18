
package ma.projet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;
    @Column(name="marqueProduit")
   private  String marque;
   @Temporal(TemporalType.DATE)
   private  Date dateAchat;
   private  double prix;
   private  String disignation;

    public Produit() {
    }

    public Produit(String marque, Date dateAchat, double prix, String disignation) {
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.disignation = disignation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDisignation() {
        return disignation;
    }

    public void setDisignation(String disignation) {
        this.disignation = disignation;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", marque=" + marque + ", dateAchat=" + dateAchat + ", prix=" + prix + ", disignation=" + disignation + '}';
    }

   
}
