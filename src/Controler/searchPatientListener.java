/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Classes.*;
import GUI.GUI;
import GUI.viewSearch;
import Modele.SearchSQL;
import Modele.connexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public class searchPatientListener implements EventHandler<ActionEvent>{

    viewSearch PatientView;
    GUI myGUI;
    connexion myCo;
    SearchSQL search;
    
    public searchPatientListener() {
    }

    public searchPatientListener(viewSearch PatientView) {
        this.PatientView = PatientView;
    }

    public searchPatientListener(viewSearch PatientView, GUI myGUI, connexion myCo, SearchSQL search) {
        this.PatientView = PatientView;
        this.myGUI = myGUI;
        this.myCo = myCo;
        this.search = search;
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
        
        String req = search.SearchPatient(Nom, Prenom, Tel, Adresse,Mutuelle);
        
        Patient[] pat = myCo.SearchPatient(req);
        
        if(pat!=null)
        {
            myGUI.getResult().setPatientResult(pat);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
}
