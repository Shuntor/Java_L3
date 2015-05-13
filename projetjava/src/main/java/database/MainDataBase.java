/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KENT
 */
public class MainDataBase {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdgestionparc";
        String utilisateur = "root";
        String motDePasse = "";
        //   Connection connexion = null;
        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)){
            

            /* Ici, nous placerons nos requêtes vers la BDD */
            /* ... */
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
