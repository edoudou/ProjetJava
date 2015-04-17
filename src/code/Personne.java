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
abstract public class Personne implements personneInterface{
    
    private int numero;
    private String nomp;
    private String prenomp;
    private int tel;
    private String adresse;

    public Personne(){
        
    }
    public Personne(int numero, String nomp, String prenomp, int tel, String adresse) {
        this.numero = numero;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.tel = tel;
        this.adresse = adresse;
    }
     public void setPersonne(int numero, String nomp, String prenomp, int tel, String adresse) {
        this.numero = numero;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomp() {
        return nomp;
    }

    public String getPrenomp() {
        return prenomp;
    }

    public int getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }    
}
