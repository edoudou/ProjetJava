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
            if(first) requete += " WHERE i.code_service LIKE ";
            else requete += " AND i.code_service LIKE";
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
            if(first) requete += " WHERE d.specialite = ";
            else requete += " AND d.specialite = ";
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
        requete = "SELECT * FROM malade m LEFT JOIN (hospitalisation h JOIN service s ON h.code_service = s.code)ON m.numero = h.no_malade";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE m.nom LIKE";
            else requete += " AND m.nom LIKE";
            requete+= "'%"+Nom+"%'";
            first = false;
        }
        
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE m.prenom LIKE ";
            else requete += " AND m.prenom LIKE";
            requete+="'%"+Prenom+"%'";
            first = false;
        }
        
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE m.tel = ";
            else requete += " AND m.tel = ";
            requete+= Tel;
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE m.adresse LIKE ";
            else requete += " AND m.adresse LIKE ";
            requete+="'%"+Adresse+"%'";
            first = false;
        }
        if(!Mutuelle.isEmpty()){
            if(first) requete += " WHERE m.mutuelle LIKE ";
            else requete += " AND m.mutuelle LIKE ";
            requete+="'%"+Mutuelle+"%'";
        }
        return requete;
    }
    
    public String SearchPatientOf(int id) {
        String requete;
        requete = "SELECT * FROM soigne so JOIN (malade m LEFT JOIN (hospitalisation h JOIN service s ON h.code_service = s.code) ON m.numero = h.no_malade) ON m.numero = so.no_malade WHERE so.no_docteur = " + id;
        
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
        requete = "SELECT * FROM service s LEFT JOIN employe e ON s.directeur = e.numero";
        if(Nom!=null&&!Nom.isEmpty()){
            if(first) requete += " WHERE s.code LIKE ";
            else requete += " AND s.code LIKE";
            requete+="'%"+Nom+"%'";
            first = false;
        }
        if(!batiment.isEmpty()){
            if(first) requete += " WHERE s.batiment = ";
            else requete += " AND s.batiment =";
            requete+="'%"+batiment+"%'";
            first = false;
        }
        if(!Directeur.isEmpty()){
            if(first) requete += " WHERE e.nom LIKE ";
            else requete += " AND e.nom LIKE ";
            requete+="'%"+Directeur+"%'";
            first = false;
        }
         if(!chambre.isEmpty()){
            if(first) requete += " WHERE s.chambre = ";
            else requete += " AND s.chambre = ";
            requete+="'%"+chambre+"%'";           
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
