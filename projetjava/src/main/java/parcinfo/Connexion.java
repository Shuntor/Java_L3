/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KENT
 */
package parcinfo;


public class Connexion {
    
    private String equipementA;
    private String equipementB;

    public Connexion(String equipementA, String equipementB) {
        this.equipementA=equipementA;
        this.equipementB=equipementB; 
        
        
        
    }

    public String getEquipementA() {
        return equipementA;  }
    
    public String getEquipementB() {
        return equipementB;
    }

    
}

