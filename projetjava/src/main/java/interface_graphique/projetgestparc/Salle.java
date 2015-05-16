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
    
    private String nomLocalSalle; 
   

    public Salle(String nom, String nomLocalSalle) {
        this.nom=nom;
        this.nomLocalSalle=nomLocalSalle;
    }

    

    public String getNom() {
        return nom;  
    }
    
    public String getNomLocalSalle() {
        return nomLocalSalle;  
    }

    

   
    
    
}

