/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Juju
 */
public class Hospitalisation {
    
    private int Numero_malade;
    private String Code_service;
    private int Numero_chambre;
    private int Lit;

    public Hospitalisation(){
        
    }
    
    public Hospitalisation(int Numero_malade, String Code_service, int Numero_chambre,int Lit) {
        this.Numero_malade = Numero_malade;
        this.Code_service = Code_service;
        this.Numero_chambre = Numero_chambre;
        this.Lit = Lit;
    }
    
    public void setHospitalisation(int Numero_malade, String Code_service, int Numero_chambre,int Lit) {
        this.Numero_malade = Numero_malade;
        this.Code_service = Code_service;
        this.Numero_chambre = Numero_chambre;
        this.Lit = Lit;
    }

    public int getNumero_malade() {
        return Numero_malade;
    }

    public String getCodeService() {
        return Code_service;
    }
    
    public int getNumero_chambre() {
        return Numero_chambre;
    }

    public int getNumLit() {
        return Lit;
    }      

}
