/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

/**
 *
 * @author Jack
 */
public class viewHome extends View{

    private TextField User;
    private PasswordField MDP,MDPSQL;
    private Button connect;
    private BorderPane pane;
    private Label Titre;
    public viewHome() {
        super();
        name = "Home";
        
        pane = new BorderPane();
        
        User = new TextField();
        MDP = new PasswordField();
        MDPSQL = new PasswordField();
        connect = new Button("Connexion");
        Titre =new Label("Bienvenue sur le logiciel de gestion d'hopital");
        
        content.getChildren().addAll(Titre,new Label("Bienvenue sur le logiciel de gestion d'hopital"),new Label("Nom d'utilisateur ECE"),User,new Label("Mot de passe ECE"),MDP,new Label("Mot de passe MySQL"),MDPSQL,connect);
        
        
        content.setPadding(new Insets(20, 10, 50, 300));
        
        pane.setCenter(content);
        content.getChildren().add(pane);
        
    }
    
    public TextField getUser() {
        return User;
    }


    public PasswordField getMDP() {
        return MDP;
    }
     
    public PasswordField getMDPSQL() {
        return MDPSQL;
    }

    public Button getConnect() {
        return connect;
    }
 
    public viewHome(String name) {
        super();
        this.name = name;
        
        pane = new BorderPane();
        
        pane.prefHeight(600);
        pane.prefWidth(800);
        
        User = new TextField();
        MDP = new PasswordField();
        MDPSQL = new PasswordField();
        
        connect = new Button("Connexion");
        Titre =new Label("Bienvenue sur le logiciel de gestion d'hopital");
        
        Titre.setFont(new Font(20));
        
        content.getChildren().addAll(Titre,new Label("Nom d'utilisateur ECE"),User,new Label("Mot de passe ECE"),MDP,new Label("Mot de passe MySQL"),MDPSQL,connect);
        
        
        content.setPadding(new Insets(20, 195, 290, 195));
        
        pane.setStyle("-fx-background-image: url(\"background.jpg\");-fx-background-size: 1000 800;-fx-background-position: center center;");
        
        pane.setCenter(content);
        
        
        //pane.setStyle("-fx-background-image: url(\"background.jpg\");-fx-background-size: 800 600;-fx-background-position: center center;");
        this.setContent(pane);
        
    }
    
    public viewHome(String name,String url) {
        super();
        this.name = name;
        /*ImageView myImg = new ImageView(new Image(url));
        myImg.setFitHeight(470);
        myImg.setFitWidth(790);
        content.getChildren().add(myImg);
        this.setContent(content);*/
    }

    
    public void setConnexionListener(EventHandler<ActionEvent> actionToPerform){
        connect.setOnAction(actionToPerform);
    }
    
    @Override
    public void addToTab(GUIComponent... component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addToTab(Object component, String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddButtonListener(EventHandler<ActionEvent> actionToPerform) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSearchButtonListener(EventHandler<ActionEvent> actionToPerform) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
