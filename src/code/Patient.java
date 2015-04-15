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
public class Patient extends Personne {
    
    private String mutuelle;

    public Patient (){
        
    }
    
    public Patient(String mutuelle, int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
        this.mutuelle = mutuelle;
    }
    
     public void setPatient(String mutuelle, int numero, String nomp, String prenomp, int tel, String adresse) {
        super.setPersonne(numero, nomp, prenomp, tel, adresse);
        this.mutuelle = mutuelle;
    }

    public String getMutuelle() {
        return mutuelle;
    }
    
    
}
