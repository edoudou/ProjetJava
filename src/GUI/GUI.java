/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controler.controler;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.*;


/**
 *
 * @author Jack
 */
public class GUI extends Application{

    private viewInterface[] appViews;
    private MenuBar myMenu;
    private Menu HomeMenu,ServiceMenu,DoctorMenu,InfirmierMenu,PatientMenu;
    private MenuItem HomeMenuItem,ServiceMenuItem,DoctorMenuItem,InfirmierMenuItem,PatientMenuItem;
    private controler myControler;
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    public GUI() {
    
    }

    public viewInterface[] getAppViews() {
        return appViews;
    }

    public void setAppViews(viewInterface[] appViews) {
        this.appViews = appViews;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Projet Java !");
        
        myMenu = new MenuBar();
        HomeMenuItem = new MenuItem("Accueil");
        DoctorMenuItem = new MenuItem("Medecin");
        PatientMenuItem = new MenuItem("Patient");
        InfirmierMenuItem = new MenuItem("Infirmier");
        ServiceMenuItem = new MenuItem("Service");
        
        HomeMenu = new Menu("Accueil");
        HomeMenu.getItems().add(HomeMenuItem);
        DoctorMenu = new Menu("Medecin");
        DoctorMenu.getItems().add(DoctorMenuItem);
        PatientMenu = new Menu("Patient");
        PatientMenu.getItems().add(PatientMenuItem);
        InfirmierMenu = new Menu("Infirmier");
        InfirmierMenu.getItems().add(InfirmierMenuItem);
        ServiceMenu = new Menu("Service");
        ServiceMenu.getItems().add(ServiceMenuItem);
        
        myMenu.getMenus().addAll(HomeMenu,DoctorMenu,PatientMenu,InfirmierMenu,ServiceMenu);
        
        
        StackPane root = new StackPane();
        Scene myScene = new Scene(root, 800, 500);
        stage.setScene(myScene);
        BorderPane layout = new BorderPane();
        
        appViews = new viewInterface[5];
        appViews[0] = new viewHome("Home","img/Hopital.jpg");
        appViews[1] = new viewSearch();
        appViews[2] = new viewSearch();
        appViews[3] = new viewSearch();
        appViews[4] = new viewSearch();
        
        layout.setTop(myMenu);
        layout.setCenter((Node)appViews[0]);
        root.getChildren().add(layout);
        
        
        
        appViews[1].addToTab(new GUIComponent(new TextField(),"Nom"),
                             new GUIComponent(new TextField(),"Prenom"),
                             new GUIComponent(new TextField(),"Numero"),
                             new GUIComponent(new TextField(),"Adresse"),
                             new GUIComponent(new ComboBox(
                                    FXCollections.observableArrayList(
                                            "Anesthesiste",
                                            "Cardiologue",
                                            "Generaliste",
                                            "Orthopediste",
                                            "Pneumologue",
                                            "Traumatologue"
                                            )),"Specialité"));
        
        appViews[2].addToTab(new GUIComponent(new TextField(),"Nom"),
                             new GUIComponent(new TextField(),"Prenom"),
                             new GUIComponent(new TextField(),"Numero"),
                             new GUIComponent(new TextField(),"Adresse"),
                             new GUIComponent(new TextField(),"Mutuelle"));
        
        appViews[3].addToTab(new GUIComponent(new TextField(),"Nom"),
                             new GUIComponent(new TextField(),"Prenom"),
                             new GUIComponent(new TextField(),"Numero"),
                             new GUIComponent(new TextField(),"Adresse"),
                             new GUIComponent(new TextField(),"Salaire"),
                             new GUIComponent(new ComboBox(
                                    FXCollections.observableArrayList(
                                            "Anesthesiste",
                                            "Cardiologue",
                                            "Generaliste",
                                            "Orthopediste",
                                            "Pneumologue",
                                            "Traumatologue"
                                            )),"Service"));
        
        appViews[4].addToTab(new GUIComponent(new ComboBox(
                                    FXCollections.observableArrayList(
                                            "Anesthesiste",
                                            "Cardiologue",
                                            "Generaliste",
                                            "Orthopediste",
                                            "Pneumologue",
                                            "Traumatologue"
                                            )),"Nom"),
                             new GUIComponent(new TextField(),"Batiment"),
                             new GUIComponent(new TextField(),"Directeur"));
        
        stage.show();
        
        myControler = new controler(this);
        
        
        HomeMenuItem.setOnAction((event) -> {
            layout.setCenter((Node)appViews[0]);
        });
        
        DoctorMenu.setOnAction((event)->{
            layout.setCenter((Node)appViews[1]);
        }
        );
        PatientMenu.setOnAction((event)->{
            layout.setCenter((Node)appViews[2]);
        }
        );
        InfirmierMenu.setOnAction((event)->{
            layout.setCenter((Node)appViews[3]);
        }
        );
        ServiceMenu.setOnAction((event)->{
            layout.setCenter((Node)appViews[4]);
        }
        );
        
    }
    
}
