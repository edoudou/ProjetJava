/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.viewHome;
import Modele.connexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Jack
 */
public class setLinkListener implements EventHandler<ActionEvent>{
    connexion myCo;
    viewHome myView;

    public setLinkListener(connexion myCo) {
        this.myCo = myCo;
    }

    public setLinkListener(connexion myCo, viewHome myView) {
        this.myCo = myCo;
        this.myView = myView;
    }
    
    
    @Override
    public void handle(ActionEvent t) {
        try {
            String username = myView.getUser().getText();
            String passwordSQL = myView.getMDPSQL().getText();
            String password = myView.getMDP().getText();
            
            if(!username.isEmpty())
                myCo.setLinkECE(username, password, passwordSQL);
            else
                myCo.setLink();
        } catch (SQLException ex) {
            System.out.println("Probleme de connection au serveur ECE");
        }
    }
    
}
