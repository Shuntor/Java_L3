/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_graphique.projetgestparc;

/**
 *
 * @author 21408234
 */
public class Ordinateur {
    private String nom;
    private String adresse;
    private String salle;   
    private String local;
    private String etat;
    private String os;

    Ordinateur(String nom/*, String adresse, String salle, String local, String etat, String os*/) {
        this.nom=nom;
        /*this.adresse=adresse;
        this.local=local;
        this.salle=salle;
        this.etat=etat;
        this.os=os;*/
        
        
        
    }

    public String getNom() {
        return nom;  }
    
    public String getAdresse() {
        return adresse;
    }

    public String getSalle() {
        return salle;
    }

    public String getLocal() {
        return local;
    }

    public String getEtat() {
        return etat;
    }

    public String getOs() {
        return os;
    }
    
    
    
}
