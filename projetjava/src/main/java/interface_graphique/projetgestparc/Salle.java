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
      
   

    Salle(String nom, String local, String taille) {
        this.nom=nom;
        this.local=local;
        
        
        
        
    }

    public String getLocal() {
        return local;
    }

    public String getNom() {
        return nom;  
    }
    
    

    

   
    
    
}

