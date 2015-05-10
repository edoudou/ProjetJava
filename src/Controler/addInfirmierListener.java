/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.viewSearch;
import Modele.AddSQL;
import Modele.SearchSQL;
import Modele.connexion;
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
    AddSQL add;
    connexion myCo;
    
    public addInfirmierListener() {
    }

    public addInfirmierListener(viewSearch InfirmierView, AddSQL add) {
        this.InfirmierView = InfirmierView;
        this.add = add;
    }

    public addInfirmierListener(viewSearch InfirmierView, AddSQL add, connexion myCo) {
        this.InfirmierView = InfirmierView;
        this.add = add;
        this.myCo = myCo;
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
        
        if(Nom!=null&&Prenom!=null&&Tel != null&&Adresse != null&&Salaire != null&&service != null
                &&!Nom.isEmpty()&&!Prenom.isEmpty()&&!Tel.isEmpty()&&!Adresse.isEmpty()&&!Salaire.isEmpty()&&!service.isEmpty())
        {
            String[] req = add.addInfirmier(Nom, Prenom, Tel, Adresse, Salaire, service);
            for(int i = 0;i < req.length;i++)
                myCo.updateData(req[i]);
        }
        
    }
    
}
