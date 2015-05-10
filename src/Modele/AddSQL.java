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

    
    // Ajout dans table employé
    public String addEmploye(String Nom, String Prenom, String Tel, String Adresse){
        String requete;
        requete = "INSERT INTO employe (nom, prenom, adresse, tel) VALUES ( ";
       
        if (!Nom.isEmpty()) {
            requete += "'"+Nom+"',";            
        }
        else requete += "NULL,";
        
        if (!Prenom.isEmpty()) {
            requete += "'"+Prenom+"',";            
        }
        else requete += "NULL,";
        
        if (!Adresse.isEmpty()) {
            requete += "'"+Adresse+"',";            
        }
        else requete += "NULL,";
        
        if (!Tel.isEmpty()) {
            requete += ""+Tel+");";            
        }
        else requete += "NULL);";
                      
        return requete;
            
    }
    
    // Ajout dans table infirmier
    public String addInfirmier(String Salaire, String service, int id){        
                
        String requete = "INSERT INTO infimier (numero, code_service, salaire) VALUES ( ";       
           
        requete += ""+id+",";       
             
        if (service != null && !service.isEmpty()) {
            requete += "'"+service+"',";            
        }
        else requete += "NULL,";
        
        if (!Salaire.isEmpty()) {
            requete += ""+Salaire+");";            
        }
        else requete += "NULL );";
        
        return requete;     
    } 
    
    
    // Ajout dans table docteur
    public String addDocteur(String spe, int id){        
                
        String requete = "INSERT INTO docteur (numero, specialite) VALUES ( ";       
           
        requete += ""+id+",";                 
            
        if (!spe.isEmpty()) {
            requete += ""+spe+");";            
        }
        else requete += "NULL );";        
        
        return requete;            
    }    
    
    // Ajout dans la table malade
    public String addPatient(String Nom,String Prenom,String Tel,String Adresse,String Mutuelle){        
                
        String requete = "INSERT INTO malade (nom, prenom, adresse, tel, mutuelle) VALUES ( ";       
          
        
        if (!Nom.isEmpty()) {
            requete += "'"+Nom+"',";            
        }
        else requete += "NULL,";
        
        if (!Prenom.isEmpty()) {
            requete += "'"+Prenom+"',";            
        }
        else requete += "NULL,";
        
        if (!Adresse.isEmpty()) {
            requete += "'"+Adresse+"',";            
        }
        else requete += "NULL,";
        
        if (!Tel.isEmpty()) {
            requete += ""+Tel+",";            
        }
        else requete += "NULL,";  
        
        if (!Mutuelle.isEmpty()) {
            requete += "'"+Mutuelle+"');";            
        }
        else requete += "NULL);"; 
        
        return requete;
    }  
    
    // Ajout dans la table chambre
    public String addChambre(String Numero_chambre,String service,String Surveillant,String nb_lits){        
                
        String requete = "INSERT INTO chambre (code_service, no_chambre, surveillant, nb_lits) VALUES ( ";       
          
        if (!service.isEmpty()) {
            requete += "'"+service+"',";            
        }
        else requete += "NULL,";
         
        if (!Numero_chambre.isEmpty()) {
            requete += ""+Numero_chambre+",";            
        }
        else requete += "NULL,";             
        
        if (!Surveillant.isEmpty()) {
            requete += ""+Surveillant+",";            
        }
        else requete += "NULL,";
        
        if (!nb_lits.isEmpty()) {
            requete += ""+nb_lits+");";            
        }
        else requete += "NULL);";         
               
        return requete;
        
    }       
   
}   