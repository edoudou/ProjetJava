/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
    
import Classes.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author Juju
 */
public class AddSQL {

    
    public String addInfirmier(String Nom, String Prenom, String Tel, String Adresse, String Salaire, String service){
        
        String requete = "INSERT INTO employe (nom, prenom, adresse, tel) VALUES ( ";
       
        if (!Nom.isEmpty()) {
            requete += ""+Nom+",";
            
        }
        else requete += "NULL,";
        
        if (!Prenom.isEmpty()) {
            requete += ""+Prenom+",";
            
        }
        else requete += "NULL,";
        
        if (!Adresse.isEmpty()) {
            requete += ""+Adresse+",";
            
        }
        else requete += "NULL,";
        
        if (!Tel.isEmpty()) {
            requete += ""+Tel+"";
            
        }
        else requete += "NULL";
        
        requete += ");";
        
        
        return requete;
            
    }
              
       
}   