/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Robin
 */
public class DeleteSQL {
    
     public String[] DeleteInfirmier (int id) {
        String[] requete = new String[2];
        
        requete[0] = "DELETE FROM Employe WHERE numero = " + id;
        requete[1] = "DELETE FROM Infirmier WHERE numero = "+ id;
        
        return requete;
    }   
    
    public String[] DeleteDocteur(int id) {
        String[] requete = new String[2];
        
        requete[0] = "DELETE FROM Employe WHERE numero = " + id;
        requete[1] = "DELETE FROM Docteur WHERE numero = "+ id;
        
        return requete;
    }   
    
    public String DeletePatient(int id) {
        String requete;
        
        requete = "DELETE FROM malade WHERE numero = " + id;
        
        
        return requete;
    }  
    
    public String DeleteChambre (int id) {
        String requete;
        
        requete = "DELETE FROM chambre WHERE numero = " + id;
        
        
        return requete;
    }   
    public String DeleteService(String id) {
        String requete;
        
        requete = "DELETE FROM service WHERE code_service LIKE " + id;
        
        
        return requete;
    }   
}

