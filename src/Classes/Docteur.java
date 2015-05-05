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
    private Patient[] patientTab;
    
    public Docteur(){
        
    }

    public Patient[] getPatientTab() {
        return patientTab;
    }

    public String getSpe() {
        return Spe;
    }

    public void setSpe(String Spe) {
        this.Spe = Spe;
    }

    public void setPatientTab(Patient[] patientTab) {
        this.patientTab = patientTab;
    }

    public Docteur(String Spe, int numero, String nomp, String prenomp, int tel, String adresse,Patient[] patientTab) {
        super(numero, nomp, prenomp, tel, adresse);
        this.Spe = Spe;
        this.patientTab = patientTab;
    }
    
    public void setDocteur(String Spe, int numero, String nomp, String prenomp, int tel, String adresse,Patient[] patientTab) {
        super.setEmploye(numero, nomp, prenomp, tel, adresse);
        this.Spe = Spe;
        this.patientTab = patientTab;
    }
    
}
