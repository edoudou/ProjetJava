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
public class addInfirmierListener implements EventHandler<ActionEvent>{

    viewSearch InfirmierView;
    
    public addInfirmierListener() {
    }

    public addInfirmierListener(viewSearch InfirmierView) {
        this.InfirmierView = InfirmierView;
    }
    
    
    
    @Override
    public void handle(ActionEvent t) {
        String Nom = null,Prenom = null,Tel = null,Adresse = null,Salaire = null,service = null;
        
        TextField Field = (TextField) InfirmierView.getTabNamed("Nom").getData();
        if(Field!=null) Nom = Field.getText();
        
        Field = (TextField) InfirmierView.getTabNamed("Prenom").getData();
        if(Field!=null) Prenom = Field.getText();
        
        Field = (TextField) InfirmierView.getTabNamed("Numero").getData();
        if(Field!=null) Tel = Field.getText();
        
        Field = (TextField) InfirmierView.getTabNamed("Adresse").getData();
        if(Field!=null) Adresse = Field.getText();
        
        Field = (TextField) InfirmierView.getTabNamed("Salaire").getData();
        if(Field!=null) Salaire = Field.getText();
        
        ComboBox combo = (ComboBox) InfirmierView.getTabNamed("Service").getData();
        if(combo!=null)service = (String) combo.getValue();
        
        System.out.println("To Do add Medecin named " + Nom + Prenom + " Tel : " + Tel +"/"+ Adresse);
        
    }
    
}
