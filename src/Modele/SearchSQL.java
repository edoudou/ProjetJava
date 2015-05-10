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
 * @author Robin
 */
public class SearchSQL {
    
    public String SearchInfirmier (String Nom,String Prenom,String Tel,String Adresse,String Salaire,String service) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM infirmier i JOIN employe e ON i.numero=e.numero";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE e.nom LIKE ";
            else requete += " AND e.nom LIKE ";
            requete+= "'%"+Nom+"%'";
            first = false;
        }
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE e.prenom LIKE ";
            else requete += " AND e.prenom LIKE ";
            requete+="'%"+Prenom+"%'";
            first = false;
        }
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE e.tel = ";
            else requete += " AND e.tel =";
            requete+=Tel;
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE e.adresse LIKE ";
            else requete += " AND e.adresse LIKE ";
            requete+="'%"+Adresse+"%'";
            first = false;
        }
        if(!Salaire.isEmpty()){
            if(first) requete += " WHERE i.salaire = ";
            else requete += " AND i.salaire = ";
            requete+=Salaire;
            first = false;
        }
        if(service!=null && !service.isEmpty()){
            if(first) requete += " WHERE i.service LIKE ";
            else requete += " AND i.service LIKE";
            requete+="'%"+service+"%'";
        }
        return requete;
    }   
    
    public String SearchDocteur(String Nom,String Prenom,String Tel,String Adresse,String spe) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM docteur d JOIN employe e ON d.numero=e.numero";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE e.nom LIKE ";
            else requete += " AND e.nom LIKE ";
            requete+= "'%"+Nom+"%'";
            first = false;
        }
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE e.prenom LIKE ";
            else requete += " AND e.prenom LIKE ";
            requete+="'%"+Prenom+"%'";
            first = false;
        }
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE e.tel = ";
            else requete += " AND e.tel =";
            requete+=Tel;
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE e.adresse LIKE ";
            else requete += " AND e.adresse LIKE ";
            requete+="'%"+Adresse+"%'";
            first = false;
        }
        if(spe!=null && !spe.isEmpty()){
            if(first) requete += " WHERE d.spe = ";
            else requete += " AND d.spe = ";
            requete+="'%"+spe+"%'";
        }
        return requete;
    }
    
    public String SearchDocteurOf(int id) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM employe e JOIN(docteur d JOIN soigne s ON d.numero = no_docteur) ON e.numero = d.numero WHERE no_malade = " + id;
        
        return requete;
    }
    
    public String SearchPatient(String Nom,String Prenom,String Tel,String Adresse,String Mutuelle) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM malade p";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE nom LIKE";
            else requete += " AND nom LIKE";
            requete+= "'%"+Nom+"%'";
            first = false;
        }
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE prenom LIKE ";
            else requete += " AND prenom LIKE";
            requete+="'%"+Prenom+"%'";
            first = false;
        }
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE tel = ";
            else requete += " AND tel = ";
            requete+= Tel;
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE adresse LIKE ";
            else requete += " AND adresse LIKE ";
            requete+="'%"+Adresse+"%'";
            first = false;
        }
        if(!Mutuelle.isEmpty()){
            if(first) requete += " WHERE mutuelle LIKE ";
            else requete += " AND mutuelle LIKE ";
            requete+="'%"+Mutuelle+"%'";
        }
        return requete;
    }
    
    public String SearchPatientOf(int id) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM malade p JOIN soigne s ON p.numero = no_malade WHERE no_docteur = " + id;
        
        return requete;
    }
    
    public String SearchChambre (String Numero_chambre,String service,String Surveillant,String nb_lits) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM chambre";
        if(!service.isEmpty()){
            if(first) requete += " WHERE code_service LIKE ";
            else requete += " AND code_service LIKE";
            requete+="%"+service+"%";
            first = false;
        }
        if(!Surveillant.isEmpty()){
            if(first) requete += " WHERE surveillant = ";
            else requete += " AND surveillant =";
            requete+="%"+Surveillant+"%";
            first = false;
        }
        if(!nb_lits.isEmpty()){
            if(first) requete += " WHERE nb_lits = ";
            else requete += " AND nb_lits = ";
            requete+="%"+nb_lits+"%";
        }
        return requete;
    }   
    
    
    public String SearchService (String Nom,String batiment,String Directeur,String chambre) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM service s";
        if(Nom!=null&&!Nom.isEmpty()){
            if(first) requete += " WHERE s.nom LIKE ";
            else requete += " AND s.nom LIKE";
            requete+="%"+Nom+"%";
            first = false;
        }
        if(!batiment.isEmpty()){
            if(first) requete += " WHERE s.batiment = ";
            else requete += " AND s.batiment =";
            requete+="%"+batiment+"%";
            first = false;
        }
        if(!Directeur.isEmpty()){
            if(first) requete += " WHERE s.directeur = ";
            else requete += " AND s.directeur = ";
            requete+="%"+Directeur+"%";
            first = false;
        }
         if(!chambre.isEmpty()){
            if(first) requete += " WHERE s.chambre = ";
            else requete += " AND s.chambre = ";
            requete+="%"+chambre+"%";           
        }
        return requete;
    } 
    
    public String SearchHospitalisation(String Numero_malade, String Code_service, String Numero_chambre, String Lit) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM hospitalisation ";
        if(!Numero_malade.isEmpty()){
            if(first) requete += " WHERE no_malade = ";
            else requete += " AND no_malade = ";
            requete+="%"+Numero_malade+"%";
            first = false;
        }
        if(Code_service != null && !Code_service.isEmpty()){
            if(first) requete += " WHERE code_service LIKE ";
            else requete += " AND code_service LIKE ";
            requete+="'%"+Code_service+"%'";
            first = false;
        }
        if(!Numero_chambre.isEmpty()){
            if(first) requete += " WHERE no_chambre = ";
            else requete += " AND no_chambre =";
            requete+="%"+Numero_chambre+"%";
            first = false;
        }
        if(!Lit.isEmpty()){
            if(first) requete += " WHERE lit = ";
            else requete += " AND lit = ";
            requete+="%"+Lit+"%";
        }
        return requete;
    }  


}
