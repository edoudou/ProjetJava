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
    
    private String service;
    private int Numero_chambre;
    private int Lit;

    public Hospitalisation(){
        
    }
    
    public Hospitalisation( String Code_service, int Numero_chambre,int Lit) {
        
        this.service = Code_service;
        this.Numero_chambre = Numero_chambre;
        this.Lit = Lit;
    }
    
    public void setHospitalisation(String Code_service, int Numero_chambre,int Lit) {
        this.service = Code_service;
        this.Numero_chambre = Numero_chambre;
        this.Lit = Lit;
    }


    public String getCodeService() {
        return service;
    }
    
    public int getNumero_chambre() {
        return Numero_chambre;
    }

    public int getNumLit() {
        return Lit;
    }      

}
