/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.GUI;
import GUI.viewSearch;

/**
 *
 * @author Jack
 */
public final class controler {

    public controler(GUI myGUI) {
        init(myGUI);
    }
    
    public void init(GUI myGUI){
        myGUI.getAppViews()[1].setAddButtonListener(new addMedecinListener((viewSearch) myGUI.getAppViews()[1]));
        myGUI.getAppViews()[1].setSearchButtonListener(new searchMedecinListener((viewSearch) myGUI.getAppViews()[1]));
        
        myGUI.getAppViews()[2].setAddButtonListener(null);
        myGUI.getAppViews()[2].setSearchButtonListener(null);
        
        myGUI.getAppViews()[3].setAddButtonListener(null);
        myGUI.getAppViews()[3].setSearchButtonListener(null);
        
        myGUI.getAppViews()[4].setAddButtonListener(null);
        myGUI.getAppViews()[4].setSearchButtonListener(null);
    }
    
}
