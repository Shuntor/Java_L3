package parcinfo;


public class Equipement {
    
    private String nom;
    private String adresse;
    private String salle;   
    private String type; 
    private String etat;
    private String os;

    public Equipement(String nom, String adresse, String type, String salle, String os, String etat) {
        this.nom=nom;
        this.adresse=adresse; 
        this.type=type;
        this.salle=salle;
        this.etat=etat;
        this.os=os;
        
        
        
    }

    public String getNom() {
        return nom;  }
    
    public String getAdresse() {
        return adresse;
    }

    public String getSalle() {
        return salle;
    }

    public String getType(){
        return type;
    }
            
    
    public String getEtat() {
        return etat;
    }

    public String getOs() {
        return os;
    }
}
