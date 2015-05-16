package parcinfo;


public class Equipement {
    
    private String nom;
    private String adresse;
    private int salle;   
   
    private String etat;
    private int os;

    public Equipement(String nom, String adresse, int salle, String etat, int os) {
        this.nom=nom;
        this.adresse=adresse; 
        this.salle=salle;
        this.etat=etat;
        this.os=os;
        
        
        
    }

    public String getNom() {
        return nom;  }
    
    public String getAdresse() {
        return adresse;
    }

    public int getSalle() {
        return salle;
    }

    
    public String getEtat() {
        return etat;
    }

    public int getOs() {
        return os;
    }
}
