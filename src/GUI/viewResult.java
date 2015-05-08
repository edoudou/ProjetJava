/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jack
 */
public final class viewResult extends View{

    private Object[] tab;
    private TilePane pane;
    private TableView table;
    private TableColumn nomCol,prenomCol;
    private VBox data,tableBox;

    public viewResult() {
        pane = new TilePane();
        pane.setPrefColumns(2);
        pane.setPrefRows(1);
        
        table = new TableView();
        tableBox = new VBox();
        data = new VBox();
        data.setStyle("-fx-border-width: 3;-fx-border-color: black;");
        
        tableBox.getChildren().add(table);
        pane.getChildren().add(tableBox);
        pane.getChildren().add(data);
        
        
        this.setContent(pane);
        
        
        //test
        Docteur Doc1 = new Docteur();
        Doc1.setDocteur("Ca", 0, "Short","Ed", 023452432, "1321",new Patient[0]);
        Docteur Doc2 = new Docteur();
        Doc2.setDocteur("Ca", 0, "Moi","Oui Moi", 023452432, "1321",new Patient[0]);
        setDoctorResult(Doc1,Doc2);
    }

    public viewResult(Object[] tab) {
        this();
        
        this.tab = tab;
    }
    
    public void setDoctorResult(Docteur... docTab){
        tab = docTab;
        
        nomCol = new TableColumn("Nom");
        prenomCol = new TableColumn("Prenom");
        table.getColumns().addAll(nomCol,prenomCol);
        
        nomCol.setCellValueFactory(
            new PropertyValueFactory<Docteur,String>("nomp")
        );
        prenomCol.setCellValueFactory(
            new PropertyValueFactory<Docteur,String>("prenomp")
        );
        
        final ObservableList<Docteur> data = FXCollections.observableArrayList(docTab);
        table.setItems(data);
        
        table.setOnMouseClicked((event)->{
            setDoctorData((Docteur)table.getSelectionModel().getSelectedItem());
        });
    }
    
    public void setDoctorData(Docteur doc){
        data.getChildren().clear();
        data.getChildren().addAll(new Label("Nom : "+doc.getNomp()),new Label("Prenom : "+doc.getPrenomp()),new Label("Adresse : "+doc.getAdresse()));
    }

    public void setInfirmierResult(Infirmier... infTab){
        tab = infTab;
        
        nomCol = new TableColumn("Nom");
        prenomCol = new TableColumn("Prenom");
        table.getColumns().addAll(nomCol,prenomCol);
        
        nomCol.setCellValueFactory(
            new PropertyValueFactory<Infirmier,String>("nomp")
        );
        prenomCol.setCellValueFactory(
            new PropertyValueFactory<Infirmier,String>("prenomp")
        );
        
        final ObservableList<Infirmier> data = FXCollections.observableArrayList(infTab);
        table.setItems(data);
        
        table.setOnMouseClicked((event)->{
            setInfirmierData((Infirmier)table.getSelectionModel().getSelectedItem());
        });
    }
    
    public void setInfirmierData(Infirmier inf){
        data.getChildren().clear();
        data.getChildren().addAll(new Label("Nom : "+inf.getNomp()),new Label("Prenom : "+inf.getPrenomp()),new Label("Adresse : "+inf.getAdresse()));
    }
    
    public void setPatientResult(Patient... patTab){
        tab = patTab;
        
        nomCol = new TableColumn("Nom");
        prenomCol = new TableColumn("Prenom");
        table.getColumns().addAll(nomCol,prenomCol);
        
        nomCol.setCellValueFactory(
            new PropertyValueFactory<Patient,String>("nomp")
        );
        prenomCol.setCellValueFactory(
            new PropertyValueFactory<Patient,String>("prenomp")
        );
        
        final ObservableList<Patient> data = FXCollections.observableArrayList(patTab);
        table.setItems(data);
        
        table.setOnMouseClicked((event)->{
            setPatientData((Patient)table.getSelectionModel().getSelectedItem());
        });
    }
    
    public void setPatientData(Patient pat){
        data.getChildren().clear();
        data.getChildren().addAll(new Label("Nom : "+pat.getNomp()),new Label("Prenom : "+pat.getPrenomp()),new Label("Adresse : "+pat.getAdresse()));
    }
    
    public void setServiceResult(Service... servTab){
        tab = servTab;
        
        nomCol = new TableColumn("Nom");
        prenomCol = new TableColumn("Prenom");
        table.getColumns().addAll(nomCol,prenomCol);
        
        nomCol.setCellValueFactory(
            new PropertyValueFactory<Service,String>("code")
        );
        prenomCol.setCellValueFactory(
            new PropertyValueFactory<Service,String>("nom")
        );
        
        final ObservableList<Service> data = FXCollections.observableArrayList(servTab);
        table.setItems(data);
        
        table.setOnMouseClicked((event)->{
            setServiceData((Service)table.getSelectionModel().getSelectedItem());
        });
    }
    
    public void setServiceData(Service serv){
        data.getChildren().clear();
        data.getChildren().addAll(new Label("Nom : "+serv.getNom()),new Label("Batiment : "+serv.getBatiment()));
    }
    
    @Override
    public void addToTab(GUIComponent... component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
