/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KENT
 */
public class Verifications {
    
     public static boolean verifNomEquipement(String nomEqu){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement verifNomEqu = connexion.createStatement();
            
            boolean verif=true;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = verifNomEqu.executeQuery( "SELECT *  FROM Appareils ;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
                String nomEquipement = resultat2.getString( "nom" );
                
                
                if (nomEquipement.equals(nomEqu)){
                    verif=false;
                }
            
            
            
            }
            
            return verif;
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;

    }
     
     public static boolean verifAdresseEquipement(String adresseEqu){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement verifAdrEqu = connexion.createStatement();
            
            boolean verif=true;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = verifAdrEqu.executeQuery( "SELECT *  FROM Appareils ;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
                String adresseEquipement = resultat2.getString( "adrMac" );
                
                
                if (adresseEquipement.equals(adresseEqu)){
                    verif=false;
                }
            
            
            
            }
            
            return verif;
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;

    } 
    
     public static boolean verifNomSalle(String nomS){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement verifNomSalle = connexion.createStatement();
            
            boolean verif=true;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = verifNomSalle.executeQuery( "SELECT *  FROM Salles ;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
                String nomSalle = resultat2.getString( "numero" );
                
                
                if (nomSalle.equals(nomS)){
                    verif=false;
                }
            
            
            
            }
            
            return verif;
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;

    } 
     
    public static boolean verifNomLocal(String nomL){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement verifNomLocal = connexion.createStatement();
            
            boolean verif=true;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = verifNomLocal.executeQuery( "SELECT *  FROM Locaux ;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
                String nomLocal = resultat2.getString( "nom" );
                
                
                if (nomLocal.equals(nomL)){
                    verif=false;
                }
            
            
            
            }
            
            return verif;
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;

    } 
     
    public static boolean verifNomVersionOs(String nomO){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement verifNomLocal = connexion.createStatement();
            
            boolean verif=true;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = verifNomLocal.executeQuery( "SELECT *  FROM Os ;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
                String nomOs = resultat2.getString( "nom" );
                String versionOs = resultat2.getString( "version" );
                String nomVersionOs=nomOs+"-"+versionOs;
                
                if (nomVersionOs.equals(nomO)){
                    verif=false;
                }
            
            
            
            }
            
            return verif;
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;

    } 
    
}
