/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.entities;

/**
 *
 * @author Asus
 */
public class produit {
    private int idP;
    private String nomprod;
    private Double prix ; 
    private int qt;
    private String description; 
    private String image; 
    private int  idcat ;

    public produit() {
    }

    public produit(int idP, String nomprod, Double prix, int qt, String description, String image, int idcat) {
        this.idP = idP;
        this.nomprod = nomprod;
        this.prix = prix;
        this.qt = qt;
        this.description = description;
        this.image = image;
        this.idcat = idcat;
    }

    public produit(String nomprod, Double prix, int qt, String description, String image, int idcat) {
        this.nomprod = nomprod;
        this.prix = prix;
        this.qt = qt;
        this.description = description;
        this.image = image;
        this.idcat = idcat;
    }

    public produit(String nomprod,  String description, String image) {
        this.nomprod = nomprod;
       
       
        this.description = description;
        this.image = image;
      
    }


    

   
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdCat() {
        return idcat;
    }

    public void setIdCat(int idcat) {
        this.idcat = idcat;
    }

    @Override
    public String toString() {
        return idP + ", nomprod=" + nomprod + ", prix=" + prix + ", qt=" + qt + ", description=" + description + ", image=" + image + ", idCat=" + idcat + '}';
    }
    
      
}
