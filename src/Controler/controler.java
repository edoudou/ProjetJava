/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Classes.*;
import GUI.*;
import Modele.*;
import javafx.scene.Node;

/**
 *
 * @author Jack
 */
public final class controler {
    
    connexion myCo;
    SearchSQL searchGen = new SearchSQL();
    DeleteSQL deleteGen = new DeleteSQL();
    GUI myGUI;
    
    public controler(GUI myGUI) {
        myCo = new connexion();
        this.myGUI = myGUI;
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
        
        
        viewHome home = (viewHome) myGUI.getAppViews()[0];
        home.setConnexionListener(new setLinkListener(myCo,(viewHome) myGUI.getAppViews()[0]));
    }
    
    public void suppDocteur(int id){
        String[] req;
        req = deleteGen.DeleteDocteur(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
    }
    
    public void suppPatient(int id){
        String req;
        req = deleteGen.DeletePatient(id);
        
        myCo.updateData(req);
    }
    
    
    
    public void suppInfirmier(int id){
        String[] req;
        req = deleteGen.DeleteInfirmier(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
    }
    
    /*public void suppService(int id){
        String[] req;
        req = deleteGen.DeleteService(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
    }*/
    
    public void getPatientOf(int id)
    {
        String req = searchGen.SearchPatientOf(id);
        
        Patient[] pat = myCo.SearchPatient(req);
        if(pat!=null)
        {
            myGUI.getResult().setPatientResult(pat);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    public void getDoctorOf(int id)
    {
        String req = searchGen.SearchDocteurOf(id);
        System.out.println(req);
        Docteur[] doc = myCo.SearchDoctor(req);
        if(doc!=null)
        {
            myGUI.getResult().setDoctorResult(doc);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
}
