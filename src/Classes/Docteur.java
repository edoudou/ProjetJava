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
public class Docteur extends Employe {
    
    private String Spe;
    
    public Docteur(){
        
    }

    public Docteur(String Spe, int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
        this.Spe = Spe;
    }
    
    public void setDocteur(String Spe, int numero, String nomp, String prenomp, int tel, String adresse) {
        super.setEmploye(numero, nomp, prenomp, tel, adresse);
        this.Spe = Spe;
    }
    
}
