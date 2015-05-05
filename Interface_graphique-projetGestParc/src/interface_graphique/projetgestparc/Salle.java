/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

/**
 *
 * @author 21408234
 */
public class Salle {
    private String nom;
    private String local;
    private String taille;   
   

    Salle(String nom, String local, String taille) {
        this.nom=nom;
        this.local=local;
        this.taille=taille;
        
        
        
    }

    public String getLocal() {
        return local;
    }

    public String getNom() {
        return nom;  
    }
    
    

    public String getTaille() {
        return taille;
    }

   
    
    
}

