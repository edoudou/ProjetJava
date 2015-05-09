/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Classes.Docteur;
import GUI.GUI;
import GUI.viewSearch;
import Modele.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public class searchMedecinListener implements EventHandler<ActionEvent>{

    viewSearch DoctorView;
    GUI myGUI;
    connexion myCo;
    
    public searchMedecinListener() {
    }

    public searchMedecinListener(viewSearch DoctorView) {
        this.DoctorView = DoctorView;
    }
    
    public searchMedecinListener(viewSearch DoctorView,GUI myGUI,connexion myCo) {
        this.DoctorView = DoctorView;
        this.myGUI = myGUI;
        this.myCo = myCo;
    }
    
    @Override
    public void handle(ActionEvent t) {
        String Nom = null,Prenom = null,Tel = null,Adresse = null,spe =null;
        
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
        
        System.out.println("To Do search Medecin named " + Nom + Prenom + " Tel : " + Tel + "/"+ Adresse);
        
        Docteur[] doc = myCo.SearchDoctor("SELECT * FROM docteur d JOIN employe e ON d.numero = e.numero");
        
        if(doc!=null)
        {
            myGUI.getResult().setDoctorResult(doc);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
}
