

import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.entity.Produit;



public class Test {
    public static void main(String[] args) {
        ProduitService ps =new ProduitService();
        ps.create(new Produit("cr8",new Date(),377,"Info"));
        ps.create(new Produit("GI",new Date(),89, "civil"));
        ps.create(new Produit("cr7",new Date(),487, "physique"));
        ps.create(new Produit("youyou",new Date(),235, "math"));
        ps.create(new Produit("houawi",new Date(),747,"geo"));
        ps.create(new Produit("samsung",new Date(),49, "chimie"));
        
       for(Produit p: ps.findAll())
      System.out.println(p.getMarque());
        System.out.println(ps.findById(2).toString()); 
        ps.delete(ps.findById(3));
        
      Produit pr = ps.findById(1);
      pr.setMarque("khsklc");
      pr.setPrix(2366);
      ps.update(pr);
      
       for(Produit p: ps.findAll()){
          if(p.getPrix()>100)
           System.out.println(p.toString());
      }
} 
     
     
    
    }
