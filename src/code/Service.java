/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Robin
 */
public class Service {
    
    private int code;
    private String nom;
    private String batiment;
    private String Directeur;
    private int chambre;
    private int infirmier;

    public Service(){
        
    }
    
    public Service(int code, String nom, String batiment, String Directeur, int chambre, int infirmier) {
        this.code = code;
        this.nom = nom;
        this.batiment = batiment;
        this.Directeur = Directeur;
        this.chambre = chambre;
        this.infirmier = infirmier;
    }

    public void setService(int code, String nom, String batiment, String Directeur, int chambre, int infirmier) {
        this.code = code;
        this.nom = nom;
        this.batiment = batiment;
        this.Directeur = Directeur;
        this.chambre = chambre;
        this.infirmier = infirmier;
    }
    
    public int getCode() {
        return code;
    }
    public String getNom() {
        return nom;
    }

    public String getBatiment() {
        return batiment;
    }

    public String getDirecteur() {
        return Directeur;
    }

    public int getChambre() {
        return chambre;
    }

    public int getInfirmier() {
        return infirmier;
    }   
}
