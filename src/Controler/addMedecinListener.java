/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.viewSearch;
import Modele.AddSQL;
import Modele.connexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public class addMedecinListener implements EventHandler<ActionEvent>{

    viewSearch DoctorView;
    AddSQL add;
    connexion myCo;

    public addMedecinListener(viewSearch DoctorView, AddSQL add, connexion myCo) {
        this.DoctorView = DoctorView;
        this.add = add;
        this.myCo = myCo;
    }
    
    
    public addMedecinListener() {
    }

    public addMedecinListener(viewSearch DoctorView) {
        this.DoctorView = DoctorView;
    }
    
    
    
    @Override
    public void handle(ActionEvent t) {
        String Nom = null,Prenom = null,Tel = null,Adresse = null,spe = null;
        
        TextField Field = (TextField) DoctorView.getTabNamed("Nom").getData();
        if(Field!=null) Nom = Field.getText();
        
        Field = (TextField) DoctorView.getTabNamed("Prenom").getData();
        if(Field!=null) Prenom = Field.getText();
        
        Field = (TextField) DoctorView.getTabNamed("Numero").getData();
        if(Field!=null) Tel = Field.getText();
        
        Field = (TextField) DoctorView.getTabNamed("Adresse").getData();
        if(Field!=null) Adresse = Field.getText();
        
        ComboBox combo = (ComboBox) DoctorView.getTabNamed("Specialité").getData();
        if(combo!=null)spe = (String) combo.getValue();
        
        if(Nom!=null&&Prenom!=null&&Tel != null&&Adresse != null&&spe != null
                &&!Nom.isEmpty()&&!Prenom.isEmpty()&&!Tel.isEmpty()&&!Adresse.isEmpty()&&!spe.isEmpty())
        {
            String[] req = add.addDocteur(Nom, Prenom, Tel, Adresse,spe);
            for(int i = 0;i < req.length;i++)
                myCo.updateData(req[i]);
        }
    }
    
}
