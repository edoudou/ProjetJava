/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.viewSearch;
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
    
    public addPatientListener() {
    }

    public addPatientListener(viewSearch PatientView) {
        this.PatientView = PatientView;
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
        
        System.out.println("To Do add Medecin named " + Nom + Prenom + " Tel : " + Tel +"/"+ Adresse);
        
    }
    
}