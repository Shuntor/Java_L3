/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import interface_graphique.projetgestparc.Ordinateur;
import interface_graphique.projetgestparc.OrdinateursTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KENT
 */
public class MainDataBase {
    private static OrdinateursTableModel otm;
    
    /**
     *
     */
    public static void initAppAppareils () {
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            //Recupérer les ordinateurs:
            Statement selectOrdi = connexion.createStatement();
            ResultSet resultat = selectOrdi.executeQuery( "SELECT nom, typeA, adrMac, idS, idO  FROM appareils;" );
            //Boucle permettant de récupérer tous les ordinateurs:
            while ( resultat.next() ) {
            //int idAppareil = resultat.getInt( "id" );
            String nomAppareil = resultat.getString( "nom" );
            String typeAppareil = resultat.getString( "typeA" );
            String adrMacAppareil = resultat.getString( "adrMac" );
            int idSalleAppareil = resultat.getInt( "idS" );
            int idOs = resultat.getInt( "idO" );
            
            //pour le moment:
            String etatA= "En Service";
            
            Ordinateur o= new Ordinateur(nomAppareil, adrMacAppareil, typeAppareil, idSalleAppareil, etatA, idOs);
            otm.addOrdinateur(o);
            
            }
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addLocaux (String nom, String adresse) {
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
            Statement insertLocal = connexion.createStatement();
            int id=2 ;
            //String requeteInsertLocal=("\"INSERT INTO Locaux (idL, nom, adresse) VALUES (1, '".concat(nom).concat("', '").concat(adresse).concat("');\"") );
            int statut = insertLocal.executeUpdate("INSERT INTO Locaux (idL, nom, adresse) VALUES ('"+id+"', '"+nom+"', '"+adresse+"');" );
            
            
            
            
            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
