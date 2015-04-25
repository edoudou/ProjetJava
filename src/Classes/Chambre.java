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
public class Chambre {
    
    private int Numero_chambre;
    private int Service;
    private String surveillant;
    private int nb_lits;

    public Chambre(){
        
    }
    
    public Chambre(int Numero_chambre, int Service, String surveillant, int nb_lits) {
        this.Numero_chambre = Numero_chambre;
        this.Service = Service;
        this.surveillant = surveillant;
        this.nb_lits = nb_lits;
    }
    
    public void setChambre(int Numero_chambre, int Service, String surveillant, int nb_lits) {
        this.Numero_chambre = Numero_chambre;
        this.Service = Service;
        this.surveillant = surveillant;
        this.nb_lits = nb_lits;
    }

    public int getNumero_chambre() {
        return Numero_chambre;
    }

    public int getService() {
        return Service;
    }

    public String getSurveillant() {
        return surveillant;
    }

    public int getNb_lits() {
        return nb_lits;
    } 
}
