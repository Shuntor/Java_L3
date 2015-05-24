/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import interface_graphique.projetgestparc.Locals;
import interface_graphique.projetgestparc.LocalsTableModel;
import interface_graphique.projetgestparc.NewJFrame;
import static interface_graphique.projetgestparc.NewJFrame.etmSimu;
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
import java.util.*;
import parcinfo.Connexion;


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
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse); //Recupérer les locaux:
        //NewJFrame.ltm=new LocalsTableModel();
                Statement selectSalle = connexion.createStatement()){
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
            
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectLocal = connexion.createStatement();
            ResultSet resultat3 = selectLocal.executeQuery( "SELECT * FROM salles;" );
            //Boucle permettant de récupérer tous les ordinateurs:
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
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT nom, typeA, adrMac, idS, idO, etat  FROM appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            //int idAppareil = resultat2.getInt( "idA" );
            String nomAppareil = resultat2.getString( "nom" );
            String typeAppareil = resultat2.getString( "typeA" );
            String adrMacAppareil = resultat2.getString( "adrMac" );
            int idSalleAppareil = resultat2.getInt( "idS" );
            int idOs = resultat2.getInt( "idO" );
            String etatAppareil = resultat2.getString( "etat" );
            
            String nomSalleAppareil=selectNomSalle(idSalleAppareil);
            String nomOs=selectNomOs(idOs);
            
            
            Equipement e=new Equipement(nomAppareil, adrMacAppareil, typeAppareil, nomSalleAppareil, nomOs, etatAppareil);
            NewJFrame.etm.addEquipement(e);
            NewJFrame.etmSimu.addEquipement(e);
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les locaux:
            //NewJFrame.ltm=new LocalsTableModel();
            Statement selectOs = connexion.createStatement();
            ResultSet resultat4 = selectOs.executeQuery( "SELECT * FROM Os;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat4.next() ) {
            int idLocal = resultat4.getInt( "idO" );
            String nom = resultat4.getString( "nom" );
            String version = resultat4.getString( "version" );
            //NewJFrame.ltm=new LocalsTableModel();
            
            //System.out.println("nom:"+nomLocal+"  adresse:"+adresseLocal);
            
            NewJFrame.jComboBoxAjoutEquipementOs.addItem(nom+"-"+version);
            NewJFrame.jComboBox8.addItem(nom+"-"+version);
            
            
            
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT idAppareilA, idAppareilB  FROM Connecter;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idA = resultat2.getInt( "idAppareilA" );
            int idB = resultat2.getInt( "idAppareilB" );
            String nomEquipementA=selectNomEquipement(idA);
            String nomEquipementB=selectNomEquipement(idB);
            
            
            
            
            Connexion c=new Connexion(nomEquipementA, nomEquipementB);
            NewJFrame.ctm.addConnexion(c);
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static String selectNomSalle(int idSalle){
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
            Statement selectNomSalle = connexion.createStatement();
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectNomSalle.executeQuery( "SELECT numero  FROM salles WHERE idS='"+idSalle+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            String nomSalle = resultat2.getString( "numero" );
            return nomSalle;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";

    }
    
    public static String selectNomEquipement(int idEqu){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
    
        }
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        
         try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement selectNomSalle = connexion.createStatement();
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectNomSalle.executeQuery( "SELECT nom  FROM Appareils  WHERE idA ='"+idEqu+"';" );
            
            while ( resultat2.next() ) {
            String nomEqu = resultat2.getString( "nom" );
            return nomEqu;
            
            
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";

    }
    
    public static String selectNomOs(int idOs){
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
            Statement selectNomOs = connexion.createStatement();
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectNomOs.executeQuery( "SELECT nom, version  FROM Os WHERE idO='"+idOs+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            String nomOs = resultat2.getString( "nom" );
            String version = resultat2.getString("version");
            String nom=(nomOs+"-"+version);
            return nom;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";

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
    
    public static String selectNomLocal(int idL){
        
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT nom  FROM locaux WHERE idL='"+idL+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            String idLocal = resultat2.getString( "nom" );
            
            return idLocal;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
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
    /* Gérer les éventuelles erreurs ici. */
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
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int selectIdMaxSalles(){
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idS)  FROM salles;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxSalles = resultat2.getInt( "max(idS)" );
            
            idMaxSalles+=1;
            return idMaxSalles;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
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
    /* Gérer les éventuelles erreurs ici. */
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
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idLocal = resultat2.getInt( "idL" );
            return idLocal;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    
    public static void addEquipement(String nomEquipement,String adresseEquipement, String osEquipement, String etatEquipement, String salleEquipement, String typeEquipement){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertLocal = connexion.createStatement();
            int id, i=1;
            int idSalle, idOs;
            String nomOsEquipement="";
            id=selectIdMaxEquipement();
            idSalle=selectIdSalle(salleEquipement);
            
            StringTokenizer tokenizer = new StringTokenizer(osEquipement, "-");

            while ( i==1) {
                nomOsEquipement=tokenizer.nextToken();
                i++;
            }
                
            idOs=selectIdOs(nomOsEquipement);
            System.out.println("idOs="+idOs);
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertLocal.executeUpdate("INSERT INTO Appareils (idA, nom, typeA, adrMac, idS, idO, etat) VALUES ('"+id+"', '"+nomEquipement+"', '"+typeEquipement+"', '"+adresseEquipement+"', '"+idSalle+"', '"+idOs+"', '"+etatEquipement+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static int selectIdMaxEquipement(){
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idA)  FROM appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxEquipement = resultat2.getInt( "max(idA)" );
            
            idMaxEquipement+=1;
            return idMaxEquipement;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
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
    /* Gérer les éventuelles erreurs ici. */
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
            ResultSet resultat2 = selectIdLocal.executeQuery( "SELECT idS  FROM Salles WHERE numero='"+nomSalle+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idSalle = resultat2.getInt( "idS" );
            return idSalle;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
     public static int selectIdOs(String nomOs){
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
            Statement selectIdLocal = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectIdLocal.executeQuery( "SELECT idO  FROM OS WHERE nom='"+nomOs+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idOs = resultat2.getInt( "idO" );
            return idOs;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
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
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static int selectIdMaxOs(){
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
            ResultSet resultat2 = selctLocalIdMax.executeQuery( "SELECT  max(idO)  FROM Os;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idMaxOs = resultat2.getInt( "max(idO)" );
            
            idMaxOs+=1;
            return idMaxOs;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    public static void supprEquipement(String nomEquipement, String adresseEquipement, String typeEquipement, String salleEquipement, String etatEquipement, String osEquipement){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement delEquipement = connexion.createStatement();
            int id;
            
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = delEquipement.executeUpdate("DELETE FROM appareils WHERE (adrMac ='"+adresseEquipement+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void supprSalle(String nom, String Local){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement delEquipement = connexion.createStatement();
            int idS;
            idS=selectIdSalle(nom);
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = delEquipement.executeUpdate("DELETE FROM salles WHERE (idS ='"+idS+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void supprLocal(String nom, String adresse){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement delEquipement = connexion.createStatement();
            int idS;
            idS=selectIdSalle(nom);
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = delEquipement.executeUpdate("DELETE FROM Locaux WHERE (nom ='"+nom+"') AND (adresse ='"+adresse+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
    public static int listesConnexionOrdinateurs(){
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
            
            Statement selectEquipements = connexion.createStatement();
            int id;
            id=5;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectEquipements.executeQuery( "SELECT nom  FROM Appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            String nom = resultat2.getString( "nom" );
            
            NewJFrame.jComboBox10.addItem(nom);
            NewJFrame.jComboBox11.addItem(nom);
            NewJFrame.jComboBox12.addItem(nom);
            
            
            
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    
    public static void addConnexion(String equipementA, String equipementB){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement insertOs = connexion.createStatement();
            int idA;
            int idB;
            idA = selectIdEquipement(equipementA);
            idB = selectIdEquipement(equipementB);
            
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertOs.executeUpdate("INSERT INTO Connecter (idAppareilA, idAppareilB) VALUES ('"+idA+"', '"+idB+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    public static int selectIdEquipement(String nomEqu){
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
            Statement selectIdEqu = connexion.createStatement();
            
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            ResultSet resultat2 = selectIdEqu.executeQuery( "SELECT idA  FROM Appareils WHERE nom='"+nomEqu+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            int idEq = resultat2.getInt( "idA" );
            return idEq;
            
            //pour le moment:
            
            }
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;

    }
    
    public static void supprConnexion(String equA, String equB){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement delConnexion = connexion.createStatement();
            int idA, idB;
            idA=selectIdEquipement(equA);
            idB=selectIdEquipement(equB);
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = delConnexion.executeUpdate("DELETE FROM Connecter WHERE (idAppareilA ='"+idA+"') AND (idAppareilB ='"+idB+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    public static void supprConnexionEquipement(String equipement){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //INSERER UN lOCAL
            Statement delConnexion = connexion.createStatement();
            int idEquipement;
            idEquipement=selectIdEquipement(equipement);
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            
            
            
            
            
            int statut = delConnexion.executeUpdate("DELETE FROM Connecter WHERE (idAppareilA ='"+idEquipement+"') OR (idAppareilB ='"+idEquipement+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
   
    
    public static void reinit_etmSimu(){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT nom, typeA, adrMac, idS, idO, etat  FROM appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            //int idAppareil = resultat2.getInt( "idA" );
            String nomAppareil = resultat2.getString( "nom" );
            String typeAppareil = resultat2.getString( "typeA" );
            String adrMacAppareil = resultat2.getString( "adrMac" );
            int idSalleAppareil = resultat2.getInt( "idS" );
            int idOs = resultat2.getInt( "idO" );
            String etatAppareil = resultat2.getString( "etat" );
            
            String nomSalleAppareil=selectNomSalle(idSalleAppareil);
            String nomOs=selectNomOs(idOs);
            
            
            Equipement e=new Equipement(nomAppareil, adrMacAppareil, typeAppareil, nomSalleAppareil, nomOs, etatAppareil);
            NewJFrame.etmSimu.addEquipement(e);
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Simulation:                                                                                                             //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void impacter(String nomEquipementHS){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer l'id de l'ordinateur concerné:
            int idEquipementHS=selectIdEquipement(nomEquipementHS);
            Equipement equipementHS=selectEquipement(idEquipementHS);
            Statement selectConnexion = connexion.createStatement();
            
            
            
            
            ResultSet resultat = selectConnexion.executeQuery( "SELECT idAppareilB FROM Connecter WHERE idAppareilA= '"+idEquipementHS+"';" );
            //
            while ( resultat.next() ) {
            int idEquipementImpacte = resultat.getInt( "idAppareilB" );
            Equipement equipementImpacte = selectEquipement(idEquipementImpacte);
            
            int j;
            int nbLignejTable51=NewJFrame.jTable5.getRowCount();
            boolean trouve=false;
            for(j=0;j<nbLignejTable51 && trouve==false;j++){
                Object equipement=NewJFrame.jTable5.getValueAt(j, 0);
                String nomEquipement=equipement.toString();
                
                if(equipementHS.getNom().equals(nomEquipement)){
                    NewJFrame.etmSimu.supprEquipement(j);
                    trouve=true;
                }
                
            }
            
            equipementHS.setEtat("HS");
            Equipement e= new Equipement(equipementHS.getNom(), equipementHS.getAdresse(), equipementHS.getType(), equipementHS.getSalle(), equipementHS.getOs(), equipementHS.getEtat());
            NewJFrame.etmSimu.addEquipement(e);
            
            //on cherche dans la jTable:
            int nbLignejTable52=NewJFrame.jTable5.getRowCount();
            int i;
            boolean trouve2=false;
            for (i=0;i<nbLignejTable52 && trouve2==false; i++){
                Object equipement=NewJFrame.jTable5.getValueAt(i, 0);
                String nomEquipement=equipement.toString();
                Object equipementAdr=NewJFrame.jTable5.getValueAt(i, 1);
                String adresseEquipement=equipementAdr.toString();
                
                if(nomEquipement.equals(equipementImpacte.getNom())==true && adresseEquipement.equals(equipementImpacte.getAdresse())==true){
                    //changer état dans la table:
                    
                    NewJFrame.etmSimu.supprEquipement(i);
                    equipementImpacte.setEtat("HS");
                    Equipement eq= new Equipement(equipementImpacte.getNom(), equipementImpacte.getAdresse(), equipementImpacte.getType(), equipementImpacte.getSalle(), equipementImpacte.getOs(), equipementImpacte.getEtat());
                    NewJFrame.etmSimu.addEquipement(eq);
                            
                    trouve2=true;
                }
                
            }//fin for
            
            if (equipementImpacte.getType().equals("Switch")==true|| equipementImpacte.getType().equals("Routeur")==true){
                impacter (equipementImpacte.getNom());
            }
            
            
            
            
            
            
            
            
           
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public static Equipement selectEquipement(int idEqu){
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectEquipement = connexion.createStatement();
            ResultSet resultat2 = selectEquipement.executeQuery( "SELECT nom, typeA, adrMac, idS, idO, etat  FROM appareils WHERE idA='"+idEqu+"';" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat2.next() ) {
            //int idAppareil = resultat2.getInt( "idA" );
            String nomAppareil = resultat2.getString( "nom" );
            String typeAppareil = resultat2.getString( "typeA" );
            String adrMacAppareil = resultat2.getString( "adrMac" );
            int idSalleAppareil = resultat2.getInt( "idS" );
            int idOs = resultat2.getInt( "idO" );
            String etatAppareil = resultat2.getString( "etat" );
            
            String nomSalleAppareil=selectNomSalle(idSalleAppareil);
            String nomOs=selectNomOs(idOs);
            
            
            Equipement e=new Equipement(nomAppareil, adrMacAppareil, typeAppareil, nomSalleAppareil, nomOs, etatAppareil);
            return e;
           // System.out.println("nom:"+nomApp+"  adresse:"+adresseLocal);
            //jComboBox4.addItem(nomLocal);
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
}