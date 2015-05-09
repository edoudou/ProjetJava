/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Classes.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class connexion {
    Connection link = null;
    public connexion(){
        
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            System.out.println("Probleme de driver");
        }
        try {
            link = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            
        } catch (SQLException ex) {
            System.out.println("Probleme de connexion a la base de donnée");
        }
    }
    
    public Docteur[] SearchDoctor(String req){
        Docteur[] tabDoc;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery(req);
            
            
            tabDoc = null;
            for(int n = 1; result.next() ;n++){
                Docteur[] tabCopy = tabDoc;
                tabDoc = new Docteur[n];
                
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tabDoc, 0, n-1);
                
                tabDoc[n-1] = new Docteur(result.getString("specialite"),result.getInt("numero"),result.getString("nom"),result.getString("prenom"),result.getInt("tel"),result.getString("adresse"),new Patient[0]);
            }
            
            return tabDoc;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        
        return null;
    }
    
}
