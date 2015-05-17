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
import static interface_graphique.projetgestparc.NewJFrame.jComboBox7;
import interface_graphique.projetgestparc.Ordinateur;
import interface_graphique.projetgestparc.OrdinateursTableModel;
import interface_graphique.projetgestparc.Salle;
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
            //Recup�rer les locaux:
            //NewJFrame.ltm=new LocalsTableModel();
            Statement selectSalle = connexion.createStatement();
            ResultSet resultat = selectSalle.executeQuery( "SELECT * FROM locaux;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
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
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recup�rer les ordinateurs:
            Statement selectLocal = connexion.createStatement();
            ResultSet resultat3 = selectLocal.executeQuery( "SELECT * FROM salles;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat3.next() ) {
            int idSalle = resultat3.getInt( "idS" );
            int idLSalle = resultat3.getInt( "idL" );            
            String nomSalle = resultat3.getString( "numero" );
            String nomLocalSalle=selectNomLocal(idLSalle);
            Salle s=new Salle(nomSalle, nomLocalSalle);
            NewJFrame.stm.addSalle(s);
            selectNomLocal(idLSalle);
            
            NewJFrame.jComboBox2.addItem(nomSalle);
            NewJFrame.jComboBox7.addItem(nomSalle);
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recup�rer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT nom, typeA, adrMac, idS, idO  FROM appareils;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
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
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recup�rer les locaux:
            //NewJFrame.ltm=new LocalsTableModel();
            Statement selectOs = connexion.createStatement();
            ResultSet resultat = selectOs.executeQuery( "SELECT * FROM Os;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat.next() ) {
            int idLocal = resultat.getInt( "idO" );
            String nom = resultat.getString( "nom" );
            String version = resultat.getString( "version" );
            //NewJFrame.ltm=new LocalsTableModel();
            
            //System.out.println("nom:"+nomLocal+"  adresse:"+adresseLocal);
            
            NewJFrame.jComboBoxAjoutEquipementOs.addItem(nom+"-"+version);
            NewJFrame.jComboBox8.addItem(nom+"-"+version);
            
            
            
            }
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
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
            
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
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
            //Recup�rer les ordinateurs:
            Statement selectLocaux = connexion.createStatement();
            ResultSet resultat = selectLocaux.executeQuery( "SELECT nom FROM Locaux;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat.next() ) {
            //int idAppareil = resultat.getInt( "id" );
            String nomLocal = resultat.getString( "nom" );
            
            
            
            }
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
        /*   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
    public static String selectNomLocal(int idL){
        
            try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT nom  FROM locaux WHERE idL='"+idL+"';" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            String idLocal = resultat2.getString( "nom" );
            
            return idLocal;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";

    }
    
    public static int selectIdMaxLocaux(){
            try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            
            Statement selctLocalIdMax = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT max(idL)  FROM locaux;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxLocaux = resultat2.getInt( "max(idL)" );
            
            idMaxLocaux+=1;
            return idMaxLocaux;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    public static void addSalles (String nom, String nomLocal) {
        
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertLocal = connexion.createStatement();
            int id;
            int idLocal;
            id=selectIdMaxSalles();
            idLocal=selectIdLocal(nomLocal);
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertLocal.executeUpdate("INSERT INTO Salles (idS, idL, numero) VALUES ('"+id+"', '"+idLocal+"', '"+nom+"');" );
            
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int selectIdMaxSalles(){
            try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idS)  FROM salles;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxSalles = resultat2.getInt( "max(idS)" );
            
            idMaxSalles+=1;
            return idMaxSalles;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    public static int selectIdLocal(String nomLocal){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement selectIdLocal = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectIdLocal.executeQuery( "SELECT idL  FROM locaux WHERE nom='"+nomLocal+"';" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idLocal = resultat2.getInt( "idL" );
            return idLocal;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    
    public static void addEquipement(String nomEquipement,String adresseEquipement, String osEquipement, String etatEquipement, String salleEquipement){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertLocal = connexion.createStatement();
            int id;
            int idSalle;
            id=selectIdMaxEquipement();
            idSalle=selectIdSalle(salleEquipement);
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertLocal.executeUpdate("INSERT INTO Salles (idA, nom, typeA, adrMac, idS, idO, etat) VALUES ('"+id+"', '"+nomEquipement+"', '"+idLocal+"', '"+nom+"');" );
            
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static int selectIdMaxEquipement(){
            try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idA)  FROM appareils;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxEquipement = resultat2.getInt( "max(idA)" );
            
            idMaxEquipement+=1;
            return idMaxEquipement;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    public static int selectIdSalle(String nomSalle){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement selectIdLocal = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectIdLocal.executeQuery( "SELECT idS  FROM Salles WHERE nom='"+nomSalle+"';" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idSalle = resultat2.getInt( "idS" );
            return idSalle;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    
    public static void addOs(String nomOs,String versionOs){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertOs = connexion.createStatement();
            int id;
            
            id=selectIdMaxOs();
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertOs.executeUpdate("INSERT INTO Os (idO, nom, version) VALUES ('"+id+"', '"+nomOs+"', '"+versionOs+"');" );
            
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static int selectIdMaxOs(){
            try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    /* G�rer les �ventuelles erreurs ici. */
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idO)  FROM Os;" );
            //Boucle permettant de r�cup�rer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxOs = resultat2.getInt( "max(idO)" );
            
            idMaxOs+=1;
            return idMaxOs;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requ�tes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
}