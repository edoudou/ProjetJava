/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;


/**
 *
 * @author Jack
 */
public class GUI extends Application{

    private viewInterface[] appViews;
    private MenuBar myMenu;
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    public GUI() {
    
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Projet Java !");
        
        myMenu = new MenuBar();
        myMenu.getMenus().addAll(new Menu("Accueil"),new Menu("Medecin"),new Menu("Patient"),new Menu("Infirmier"),new Menu("Service"));
        
        
        StackPane root = new StackPane();
        Scene myScene = new Scene(root, 800, 500);
        stage.setScene(myScene);
        BorderPane layout = new BorderPane();
        
        layout.setTop(myMenu);
        root.getChildren().add(layout);
        //root.getChildren().addAll(myMenu);

        stage.show();
    }
    
}
