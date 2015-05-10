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
public class Patient extends Personne {
    
    private String mutuelle;
    private Hospitalisation hospital;

    public Patient (){
        mutuelle = "";
        int numero = 0;
        String nomp = "";
        String prenomp ="";
        int tel = 0;
        String adresse= "";
        
    }
    
    public Patient(String mutuelle, int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
        this.mutuelle = mutuelle;
    }

    public Patient(String mutuelle, Hospitalisation hospital, int numero, String nomp, String prenomp, int tel, String adresse) {
        super(numero, nomp, prenomp, tel, adresse);
        this.mutuelle = mutuelle;
        this.hospital = hospital;
    }

    public Hospitalisation getHospital() {
        return hospital;
    }
    
     public void setPatient(String mutuelle, int numero, String nomp, String prenomp, int tel, String adresse) {
        super.setPersonne(numero, nomp, prenomp, tel, adresse);
        this.mutuelle = mutuelle;
    }

    public String getMutuelle() {
        return mutuelle;
    }
    
    
}
