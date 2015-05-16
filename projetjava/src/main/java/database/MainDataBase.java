/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import interface_graphique.projetgestparc.Locals;
import interface_graphique.projetgestparc.LocalsTableModel;
import interface_graphique.projetgestparc.NewJFrame;
import static interface_graphique.projetgestparc.NewJFrame.jComboBox4;
import interface_graphique.projetgestparc.Ordinateur;
import interface_graphique.projetgestparc.OrdinateursTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parcinfo.Equipement;

/**
 *
 * @author KENT
 */
public class MainDataBase {
    private static OrdinateursTableModel otm;
    
    
    
    
    /**
     *
     */
    public static void initApp () {
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les locaux:
            //NewJFrame.ltm=new LocalsTableModel();
            Statement selectSalle = connexion.createStatement();
            ResultSet resultat = selectSalle.executeQuery( "SELECT * FROM locaux;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat.next() ) {
            int idLocal = resultat.getInt( "idL" );
            String nomLocal = resultat.getString( "nom" );
            String adresseLocal = resultat.getString( "adresse" );
            //NewJFrame.ltm=new LocalsTableModel();
            Locals l=new Locals(nomLocal, adresseLocal);
            NewJFrame.ltm.addLocal(l);
            System.out.println("nom:"+nomLocal+"  adresse:"+adresseLocal);
            
            NewJFrame.jComboBox4.addItem(nomLocal);
            NewJFrame.jComboBox5.addItem(nomLocal);
            
            
            
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT nom, typeA, adrMac, idS, idO  FROM appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idAppareil = resultat2.getInt( "id" );
            String nomAppareil = resultat2.getString( "nom" );
            String typeAppareil = resultat2.getString( "typeA" );
            String adrMacAppareil = resultat2.getString( "adrMac" );
            int idSalleAppareil = resultat2.getInt( "idS" );
            int idOs = resultat2.getInt( "idO" );
            
            //pour le moment:
            String etatA= "En Service";
            
            Equipement e=new Equipement(nomAppareil, adrMacAppareil, idSalleAppareil, etatA, idOs);
            NewJFrame.etm.addEquipement(e);
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addLocaux (String nom, String adresse) {
        
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertLocal = connexion.createStatement();
            int id;
            id=selectIdMaxLocaux();
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertLocal.executeUpdate("INSERT INTO Locaux (idL, nom, adresse) VALUES ('"+id+"', '"+nom+"', '"+adresse+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /*public static void selectLocauxAjoutListe() {
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectLocaux = connexion.createStatement();
            ResultSet resultat = selectLocaux.executeQuery( "SELECT nom FROM Locaux;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat.next() ) {
            //int idAppareil = resultat.getInt( "id" );
            String nomLocal = resultat.getString( "nom" );
            
            
            
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
        /*   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
    public static int selectIdMaxLocaux(){
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
            Statement selctLocalIdMax = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT max(idL)  FROM locaux;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxLocaux = resultat2.getInt( "max(idL)" );
            
            idMaxLocaux+=1;
            return idMaxLocaux;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
}