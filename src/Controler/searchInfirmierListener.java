/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Classes.*;
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
public class searchInfirmierListener implements EventHandler<ActionEvent>{

    viewSearch InfirmierView;
    GUI myGUI;
    connexion myCo;
    SearchSQL search;
    
    public searchInfirmierListener(){
    }

    public searchInfirmierListener(viewSearch InfirmierView) {
        this.InfirmierView = InfirmierView;
    }

    public searchInfirmierListener(viewSearch InfirmierView, GUI myGUI, connexion myCo, SearchSQL search) {
        this.InfirmierView = InfirmierView;
        this.myGUI = myGUI;
        this.myCo = myCo;
        this.search = search;
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
        
        String req = search.SearchInfirmier(Nom, Prenom, Tel, Adresse, Salaire, service);
        
        System.out.println(req);
        
        Infirmier[] inf = myCo.SearchInfirmier(req);
        
        if(inf!=null)
        {
            myGUI.getResult().setInfirmierResult(inf);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
        
        
    }
    
}
