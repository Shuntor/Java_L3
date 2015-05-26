/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import interface_graphique.projetgestparc.NewJFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author KENT
 */
public class InformationsConnexion {
    
    public static String urlBD() {
        String filePath = "conf.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformationsConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int i=1;
        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
 
            System.out.println(line);
            StringTokenizer tokenizer = new StringTokenizer(line, "||");
            if(i==1){
                String urlServer=tokenizer.nextToken();
                System.out.println("url="+urlServer);
                return urlServer;
            }
            i++;
            
        }
        
        scanner.close();
        return null;
    }
    
    public static String utilisateurBD() {
        String filePath = "conf.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformationsConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int i=1;
        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
 
            System.out.println(line);
            StringTokenizer tokenizer = new StringTokenizer(line, "||");
            String utilisateurServer="";
            while ( i<=2) {
                utilisateurServer=tokenizer.nextToken();
                i++;
            }
            System.out.println("utilisateur="+utilisateurServer);
            return utilisateurServer;
            
            
            
        }
        
        scanner.close();
        return null;
    }
    
    public static String mdpBD() {
        String filePath = "conf.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformationsConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int i=1;
        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
 
            System.out.println(line);
            StringTokenizer tokenizer = new StringTokenizer(line, "||");
            String mdpServer="";
            while ( i<=3) {
                try{
                    mdpServer=tokenizer.nextToken();
                }
                catch(java.util.NoSuchElementException e){
                    mdpServer="";
                }
                i++;
            }
            System.out.println("Mot de passe="+mdpServer);
           
            return mdpServer;
            
            
            
        }
        
        scanner.close();
        return null;
    }
}
