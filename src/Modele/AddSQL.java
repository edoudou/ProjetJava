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
    
    int A_I = -1;
    
    public void defineAI(int max){
        if(A_I<max)A_I = max;
    }

    public String addEmploye(String Nom, String Prenom, String Tel, String Adresse){
        String requete;
        requete = "INSERT INTO employe (numero";
        if (!Nom.isEmpty()) {
            requete += ",nom";
        }

        if (!Prenom.isEmpty()) {
            requete += ",prenom";
        }

        if (!Adresse.isEmpty()) {
            requete += ",adresse";
        }

        if (!Tel.isEmpty()) {
            requete += ",tel";
        }
        
                
        requete+=") VALUES ( ";
        
        requete += ""+A_I+"";

        if (!Nom.isEmpty()) {
            requete += ",'"+Nom+"'";
        }

        if (!Prenom.isEmpty()) {
            requete += ",'"+Prenom+"'";
        }

        if (!Adresse.isEmpty()) {
            requete += ",'"+Adresse+"'";
        }

        if (!Tel.isEmpty()) {
            requete += ","+Tel+"";
        }
        requete +=");";

        return requete;
            
    }
    
    // Ajout dans table infirmier
    public String[] addInfirmier(String Nom, String Prenom, String Tel, String Adresse,String Salaire, String service){        
        String[] requete = new String[2];   
        requete[0] = addEmploye(Nom,Prenom,Tel,Adresse);
        
        requete[1] = "INSERT INTO infirmier (numero";
                
        if (service != null && !service.isEmpty()) {
            requete[1] += ",code_service";
        }

        if (!Salaire.isEmpty()) {
            requete[1] += ",salaire";
        }
                
        requete[1] +=") VALUES ( ";
           
        requete[1] += ""+A_I+"";
             
        if (service != null && !service.isEmpty()) {
            requete[1] += ",'"+service+"'";            
        }
        
        if (!Salaire.isEmpty()) {
            requete[1] += ","+Salaire+"";
        }
        requete[1]+= ");";
        A_I++;
        
        return requete;     
    } 
    
    
    // Ajout dans table docteur
    public String[] addDocteur(String Nom, String Prenom, String Tel, String Adresse,String spe){        
        String[] requete = new String[2];   
        requete[0] = addEmploye(Nom,Prenom,Tel,Adresse);
        requete[1] = "INSERT INTO docteur (numero";
        if (spe!=null&&spe.isEmpty()) {
            requete[1] += ",specialite";            
        }
        requete[1]+= ") VALUES ( ";       
           
        requete[1] += ""+A_I+"";                 
            
        if (spe!=null&&spe.isEmpty()) {
            requete[1] += ",'"+spe+"'";            
        }
        
        requete[1] += ");";
        
        A_I++;
        
        return requete;            
    }    
    
    // Ajout dans la table malade
    public String addPatient(String Nom,String Prenom,String Tel,String Adresse,String Mutuelle){        
                
        String requete = "INSERT INTO malade (numero,nom, prenom, adresse, tel, mutuelle) VALUES ( ";       
        
        requete += ""+A_I+",";
        
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
        
        A_I++;
        
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
    
    // Ajout dans la table chambre
    public String addHospi(String Numero_malade, String Code_service, String Numero_chambre, String Lit){        
                
        String requete = "INSERT INTO hospitalisation (no_malade, code_service, no_chambre, lit) VALUES ( ";       
          
        
        requete += ""+Numero_malade+","; 
        
        
        if (!Code_service.isEmpty()) {
            requete += "'"+Code_service+"',";            
        }
        else requete += "NULL,";
         
        if (!Numero_chambre.isEmpty()) {
            requete += ""+Numero_chambre+",";            
        }
        else requete += "NULL,";             
        
        if (!Lit.isEmpty()) {
            requete += ""+Lit+");";            
        }
        else requete += "NULL);";         
               
        return requete;
        
    }

   
}   