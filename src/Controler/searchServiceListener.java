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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public class searchServiceListener implements EventHandler<ActionEvent>{

    viewSearch ServiceView;
    GUI myGUI;
    connexion myCo;
    SearchSQL search;
    
    public searchServiceListener() {
    }

    public searchServiceListener(viewSearch ServiceView) {
        this.ServiceView = ServiceView;
    }

    public searchServiceListener(viewSearch ServiceView, GUI myGUI, connexion myCo, SearchSQL search) {
        this.ServiceView = ServiceView;
        this.myGUI = myGUI;
        this.myCo = myCo;
        this.search = search;
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
        
        String req = search.SearchService(Nom,Batiment,Directeur,"");
        
        Service[] pat = myCo.SearchService(req);
        
        if(pat!=null)
        {
            myGUI.getResult().setServiceResult(pat);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
}
