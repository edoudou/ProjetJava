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
public class searchServiceListener implements EventHandler<ActionEvent>{

    viewSearch ServiceView;
    
    public searchServiceListener() {
    }

    public searchServiceListener(viewSearch ServiceView) {
        this.ServiceView = ServiceView;
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
        
        System.out.println("To Do search Service named " + Nom );
    }
    
}
