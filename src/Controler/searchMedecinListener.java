/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.viewSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public class searchMedecinListener implements EventHandler<ActionEvent>{

    viewSearch DoctorView;
    
    public searchMedecinListener() {
    }

    public searchMedecinListener(viewSearch DoctorView) {
        this.DoctorView = DoctorView;
    }
    
    @Override
    public void handle(ActionEvent t) {
        TextField NameField = (TextField) DoctorView.getTabNamed("Name").getData();
        String Name = NameField.getText();
        
        System.out.println("To Do search Medecin named "+ Name);
    }
    
}
