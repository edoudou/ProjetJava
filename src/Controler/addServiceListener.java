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
public class addServiceListener implements EventHandler<ActionEvent>{

    viewSearch ServiceView;
    AddSQL add;
    connexion myCo;
    
    public addServiceListener() {
    }

    public addServiceListener(viewSearch ServiceView) {
        this.ServiceView = ServiceView;
    }

    public addServiceListener(viewSearch ServiceView, AddSQL add, connexion myCo) {
        this.ServiceView = ServiceView;
        this.add = add;
        this.myCo = myCo;
    }
    
    
    
    @Override
    public void handle(ActionEvent t) {
        String Nom = null,Batiment = null,Directeur = null;
        
        TextField Field = (TextField) ServiceView.getTabNamed("Batiment").getData();
        if(Field!=null) Batiment = Field.getText();
        
        Field = (TextField) ServiceView.getTabNamed("Directeur").getData();
        if(Field!=null) Directeur = Field.getText();
        
        ComboBox combo = (ComboBox) ServiceView.getTabNamed("Nom").getData();
        if(combo!=null)Nom = (String) combo.getValue();
        
    }
    
}
