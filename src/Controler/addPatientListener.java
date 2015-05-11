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
public class addPatientListener implements EventHandler<ActionEvent>{

    viewSearch PatientView;
    AddSQL add;
    connexion myCo;
    
    public addPatientListener() {
    }

    public addPatientListener(viewSearch PatientView) {
        this.PatientView = PatientView;
    }

    public addPatientListener(viewSearch PatientView, AddSQL add, connexion myCo) {
        this.PatientView = PatientView;
        this.add = add;
        this.myCo = myCo;
    }
    
    
    
    @Override
    public void handle(ActionEvent t) {
        String Nom = null,Prenom = null,Tel = null,Adresse = null,Mutuelle = null;
        
        TextField Field = (TextField) PatientView.getTabNamed("Nom").getData();
        if(Field!=null) Nom = Field.getText();
        
        Field = (TextField) PatientView.getTabNamed("Prenom").getData();
        if(Field!=null) Prenom = Field.getText();
        
        Field = (TextField) PatientView.getTabNamed("Numero").getData();
        if(Field!=null) Tel = Field.getText();
        
        Field = (TextField) PatientView.getTabNamed("Adresse").getData();
        if(Field!=null) Adresse = Field.getText();
        
        Field = (TextField) PatientView.getTabNamed("Mutuelle").getData();
        if(Field!=null) Mutuelle = Field.getText();
        
        if(Nom!=null&&Prenom!=null&&Tel != null&&Adresse != null&&Mutuelle != null
                &&!Nom.isEmpty()&&!Prenom.isEmpty()&&!Tel.isEmpty()&&!Adresse.isEmpty()&&!Mutuelle.isEmpty())
        {
            String req = add.addPatient(Nom, Prenom, Tel, Adresse,Mutuelle);
            /*for(int i = 0;i < req.length;i++)
                myCo.updateData(req[i]);*/
            myCo.updateData(req);
        }
    }
    
}
