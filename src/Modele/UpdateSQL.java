/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Juju
 */
public class UpdateSQL {
    
    
    // Modification dans la table employé
    public String updateEmploye(String Nom, String Prenom, String Tel, String Adresse, int id){
        
        String requete;
        requete = " UPDATE employe SET nom = '"+ Nom +"', " +
                " prenom = '"+ Prenom +"', " +
               	" adresse = '"+Adresse+"', " +
                " tel = "+Tel+", " +
            	" WHERE numero = "+id+"; " ;
                    
        return requete;
            
    }
    
    // Modification dans la table infirmier
    public String updateInfirmier(String Salaire, String service, int id){        
                
        String requete;
        requete = " UPDATE infirmier SET code_service = '"+service+"', " +
                " salaire = "+Salaire+", " +
            	" WHERE numero = "+id+"; " ;
                    
        return requete;        
          
    } 
    
    
    // Modification dans la table docteur
    public String updateDocteur(String spe, int id){                
        
        String requete;
        requete = " UPDATE docteur SET specialite = '"+spe+"', " +                
            	" WHERE numero = "+id+"; " ;
                    
        return requete;          
    }    
    
    // Modification dans la table malade
    public String updatePatient(String Nom,String Prenom,String Tel,String Adresse,String Mutuelle, int id){        
                
        String requete;
        requete = " UPDATE malade SET nom = '"+ Nom +"', " +
                " prenom = '"+ Prenom +"', " +
               	" adresse = '"+Adresse+"', " +
                " tel = "+Tel+", " +
                " mutuelle = '"+Mutuelle+"', " +
            	" WHERE numero = "+id+" ;";
                    
        return requete;
    }  
    
    
}
