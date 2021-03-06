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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jack
 */
public final class controler {
    
    connexion myCo;
    AddSQL addGen = new AddSQL();
    SearchSQL searchGen = new SearchSQL();
    UpdateSQL updateGen = new UpdateSQL();
    DeleteSQL deleteGen = new DeleteSQL();
    GUI myGUI;
    
    public controler(GUI myGUI) {
        myCo = new connexion();
        this.myGUI = myGUI;
        init(myGUI);
        
        addGen.defineAI(myCo.getA_I()+1);
    }
    
    public void init(GUI myGUI){
        myGUI.getAppViews()[1].setAddButtonListener(new addMedecinListener((viewSearch) myGUI.getAppViews()[1],addGen,myCo));
        myGUI.getAppViews()[1].setSearchButtonListener(new searchMedecinListener((viewSearch) myGUI.getAppViews()[1],myGUI,myCo,searchGen));
        
        myGUI.getAppViews()[2].setAddButtonListener(new addPatientListener((viewSearch) myGUI.getAppViews()[2],addGen,myCo));
        myGUI.getAppViews()[2].setSearchButtonListener(new searchPatientListener((viewSearch) myGUI.getAppViews()[2],myGUI,myCo,searchGen));
        
        myGUI.getAppViews()[3].setAddButtonListener(new addInfirmierListener((viewSearch) myGUI.getAppViews()[3],addGen,myCo));
        myGUI.getAppViews()[3].setSearchButtonListener(new searchInfirmierListener((viewSearch) myGUI.getAppViews()[3],myGUI,myCo,searchGen));
        
        //myGUI.getAppViews()[4].setAddButtonListener(new addServiceListener((viewSearch) myGUI.getAppViews()[4],addGen,myCo));
        myGUI.getAppViews()[4].setSearchButtonListener(new searchServiceListener((viewSearch) myGUI.getAppViews()[4],myGUI,myCo,searchGen));
        
        
        viewHome home = (viewHome) myGUI.getAppViews()[0];
        home.setConnexionListener(new setLinkListener(myCo,(viewHome) myGUI.getAppViews()[0],addGen));
    }
    
    public void suppDocteur(int id){
        String[] req;
        req = deleteGen.DeleteDocteur(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
        
        String req2 = searchGen.SearchDocteur("", "", "", "", "");
        
        Docteur[] doc = myCo.SearchDoctor(req2);
        
        if(doc!=null)
        {
            myGUI.getResult().setDoctorResult(doc);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
    public void suppPatient(int id){
        String[] req;
        req = deleteGen.DeletePatient(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
        
        String req2 = searchGen.SearchPatient("", "", "", "","");
        
        Patient[] pat = myCo.SearchPatient(req2);
        
        if(pat!=null)
        {
            myGUI.getResult().setPatientResult(pat);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
    
    
    public void suppInfirmier(int id){
        String[] req;
        req = deleteGen.DeleteInfirmier(id);
        for(int i = 0; i < req.length ; i++)
            myCo.updateData(req[i]);
        
        String req2 = searchGen.SearchInfirmier("", "", "", "", "", "");
        
        Infirmier[] inf = myCo.SearchInfirmier(req2);
        
        if(inf!=null)
        {
            myGUI.getResult().setInfirmierResult(inf);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
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
        Docteur[] doc = myCo.SearchDoctor(req);
        if(doc!=null)
        {
            myGUI.getResult().setDoctorResult(doc);
        
            myGUI.getLayout().setCenter((Node)myGUI.getResult());
        }
    }
    
    public void updateInf(int id,String nom,String prenom,String adresse,String tel,String salaire,String service){
        String req;
        req = updateGen.updateEmploye(nom, prenom, tel, adresse, id);
        myCo.updateData(req);
        
        req = updateGen.updateInfirmier(salaire, service, id);
        myCo.updateData(req);
    }
    
    public void updateDoc(int id,String nom,String prenom,String adresse,String tel,String spe){
        String req;
        req = updateGen.updateEmploye(nom, prenom, tel, adresse, id);
        myCo.updateData(req);
        
        req = updateGen.updateDocteur(spe, id);
        myCo.updateData(req);
    }
    
    public void updatePat(int id,String nom,String prenom,String adresse,String tel,String mutuelle){
        String req;
        req = updateGen.updatePatient(nom, prenom, tel, adresse,mutuelle, id);
        myCo.updateData(req);
        
    }
    
    public void report(viewReporting view){
        String[][] tab = myCo.getServicePatient();
        if(tab!=null){
            view.serviceStatClear();
            for(int i = 0; i < 3; i++){
                

                view.serviceStatAdd(tab[i][1], Integer.parseInt(tab[i][0]));
            }
        }
        
        tab = myCo.getDoctorPatient();
        
        if(tab!=null){
            view.doctorStatClear();
            for(int i = 0; i < tab.length ; i++){
                

                view.doctorStatAdd(tab[i][1], Integer.parseInt(tab[i][0]));
            }
        }
    }

}
