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
    private final String nom;
    private final String adresse;
    private final String salle;   
    //private final String local;
    private final String etat;
    
    private final String os;
    private final String type;

    Ordinateur(String nom, String adresse, String type, String salle, String etat, String os) {
        this.nom=nom;
        this.adresse=adresse;
       // this.local=local;
        this.type=type;
        this.salle=salle;
        this.etat=etat;
        this.os=os;
        
        
        
    }

    Ordinateur(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Ordinateur(String nomAppareil, String adrMacAppareil, String typeAppareil, int idSalleAppareil, String etatA, int idOs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;  }
    
    public String getAdresse() {
        return adresse;
    }

    public String getSalle() {
        return salle;
    }

    /*public String getLocal() {
        return local;
    }*/

    public String getEtat() {
        return etat;
    }

    public String getOs() {
        return os;
    }
    
    
    
}
