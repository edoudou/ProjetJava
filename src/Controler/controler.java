/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.GUI;
import GUI.viewSearch;
import Modele.*;

/**
 *
 * @author Jack
 */
public final class controler {
    
    connexion myCo;
    SearchSQL searchGen = new SearchSQL();
    DeleteSQL deleteGen = new DeleteSQL();
    
    public controler(GUI myGUI) {
        myCo = new connexion();
        
        init(myGUI);
    }
    
    public void init(GUI myGUI){
        myGUI.getAppViews()[1].setAddButtonListener(new addMedecinListener((viewSearch) myGUI.getAppViews()[1]));
        myGUI.getAppViews()[1].setSearchButtonListener(new searchMedecinListener((viewSearch) myGUI.getAppViews()[1],myGUI,myCo,searchGen));
        
        myGUI.getAppViews()[2].setAddButtonListener(new addPatientListener((viewSearch) myGUI.getAppViews()[2]));
        myGUI.getAppViews()[2].setSearchButtonListener(new searchPatientListener((viewSearch) myGUI.getAppViews()[2],myGUI,myCo,searchGen));
        
        myGUI.getAppViews()[3].setAddButtonListener(new addInfirmierListener((viewSearch) myGUI.getAppViews()[3]));
        myGUI.getAppViews()[3].setSearchButtonListener(new searchInfirmierListener((viewSearch) myGUI.getAppViews()[3],myGUI,myCo,searchGen));
        
        myGUI.getAppViews()[4].setAddButtonListener(new addServiceListener((viewSearch) myGUI.getAppViews()[4]));
        myGUI.getAppViews()[4].setSearchButtonListener(new searchServiceListener((viewSearch) myGUI.getAppViews()[4],myGUI,myCo,searchGen));
    }
    
    public void suppDocteur(int id){
        String[] req;
        req = deleteGen.DeleteDocteur(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
    }
}
