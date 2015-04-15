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
public class Employe extends Personne {
    
    public Employe(){
        
    }
    
    public Employe(int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
    }
    
    public void setEmploye(int numero, String nomp, String prenomp, int tel, String adresse) {
        super.setPersonne(numero, nomp, prenomp, tel, adresse);
    }
    
    
}
