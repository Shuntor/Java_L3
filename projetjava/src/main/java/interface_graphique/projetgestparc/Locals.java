/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

/**
 *
 * @author 21408234
 */
public class Locals {
    private String nom;
    private String adresse;
    private String taille;   
   

    Locals(String nom, String adresse, String taille) {
        this.nom=nom;
        this.adresse=adresse;
        this.taille=taille;
        
        
        
    }

    public String getNom() {
        return nom;  }
    
    public String getAdresse() {
        return adresse;
    }

    public String getTaille() {
        return taille;
    }

   
    
    
}

