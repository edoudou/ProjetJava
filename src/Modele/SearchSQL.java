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
        requete = "SELECT * FROM Infirmier i JOIN Employe e ON i.numero=e.numero";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE e.nom LIKE";
            else requete += " AND e.nom LIKE";
            requete+= "%"+Nom+"%";
            first = false;
        }
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE e.prenom LIKE ";
            else requete += " AND e.prenom LIKE";
            requete+="%"+Prenom+"%";
            first = false;
        }
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE e.tel = ";
            else requete += " AND e.tel =";
            requete+="%"+Tel+"%";
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE e.adresse LIKE ";
            else requete += " AND e.adresse LIKE ";
            requete+="%"+Adresse+"%";
            first = false;
        }
        if(!Salaire.isEmpty()){
            if(first) requete += " WHERE i.salaire = ";
            else requete += " AND i.salaire = ";
            requete+="%"+Salaire+"%";
            first = false;
        }
        if(!service.isEmpty()){
            if(first) requete += " WHERE i.service LIKE ";
            else requete += " AND i.service LIKE";
            requete+="%"+service+"%";
            first = false;
        }
        return requete;
    }   
    
    public String SearchDocteur(String Nom,String Prenom,String Tel,String Adresse,String spe) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM docteur d JOIN Employe e ON d.numero=e.numero";
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
            requete+="%"+Tel+"%";
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
            first = false;
        }
        return requete;
    }   
    
    public String SearchPatient(String Nom,String Prenom,String Tel,String Adresse,String Mutuelle) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM patient p JOIN Employe e ON p.numero=e.numero";
        if(!Nom.isEmpty()){
            if(first) requete += " WHERE e.nom LIKE";
            else requete += " AND e.nom LIKE";
            requete+= "%"+Nom+"%";
            first = false;
        }
        if(!Prenom.isEmpty()){
            if(first) requete += " WHERE e.prenom LIKE ";
            else requete += " AND e.prenom LIKE";
            requete+="%"+Prenom+"%";
            first = false;
        }
        if(!Tel.isEmpty()){
            if(first) requete += " WHERE e.tel = ";
            else requete += " AND e.tel =";
            requete+="%"+Tel+"%";
            first = false;
        }
        if(!Adresse.isEmpty()){
            if(first) requete += " WHERE e.adresse LIKE ";
            else requete += " AND e.adresse LIKE ";
            requete+="%"+Adresse+"%";
            first = false;
        }
        if(!Mutuelle.isEmpty()){
            if(first) requete += " WHERE p.mutuelle = ";
            else requete += " AND p.mutuelle = ";
            requete+="%"+Mutuelle+"%";
            first = false;
        }
        return requete;
    }  
    
    public String SearchChambre (String Numero_chambre,String service,String Surveillant,String nb_lits) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM chambre c";
        if(!service.isEmpty()){
            if(first) requete += " WHERE c.service LIKE ";
            else requete += " AND c.service LIKE";
            requete+="%"+service+"%";
            first = false;
        }
        if(!Surveillant.isEmpty()){
            if(first) requete += " WHERE c.surveillant = ";
            else requete += " AND c.surveillant =";
            requete+="%"+Surveillant+"%";
            first = false;
        }
        if(!nb_lits.isEmpty()){
            if(first) requete += " WHERE c.nb_lits = ";
            else requete += " AND c.nb_lits = ";
            requete+="%"+nb_lits+"%";
            first = false;
        }
        return requete;
    }   
    public String SearchService (String Nom,String batiment,String Directeur,String chambre) {
        String requete;
        boolean first = true;
        requete = "SELECT * FROM service s";
        if(!Nom.isEmpty()){
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
            first = false;
        }
        return requete;
    }   
}
