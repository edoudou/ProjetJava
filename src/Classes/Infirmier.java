/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Robin
 */
public class Infirmier extends Employe {
    
    private String Service;
    private String rotation;
    private double salaire;
    
    public Infirmier(){
        
    }
    
    public Infirmier(String Service, String rotation, double salaire, int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
        this.Service = Service;
        this.rotation = rotation;
        this.salaire = salaire;
    }
    
    public void setInfirmier(String Service, String rotation, double salaire, int numero, String nomp, String prenomp, int tel, String adresse) {
        super.setEmploye(numero, nomp, prenomp, tel, adresse);
        this.Service = Service;
        this.rotation = rotation;
        this.salaire = salaire;
    }
}
