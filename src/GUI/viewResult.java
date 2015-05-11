/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.*;
import Controler.controler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jack
 */
public final class viewResult extends View{

    private Object[] tab;
    private GridPane pane;
    private TableView table;
    private AnchorPane anchor;
    private TableColumn nomCol,prenomCol;
    private VBox data,tableBox;
    private controler control;

    public viewResult() {
        
        anchor = new AnchorPane();
        pane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(399);

        ColumnConstraints column2 = new ColumnConstraints(399);

        pane.getColumnConstraints().addAll(column1, column2);
        
        
        table = new TableView();
        tableBox = new VBox();
        data = new VBox();
        data.setStyle("-fx-border-width: 3;-fx-border-color: black;-fx-pref-width : 50%");
        
        tableBox.getChildren().add(table);
        
        
        
        pane.add(tableBox,0,1);
        pane.add(data,1,1);
        
        anchor.setStyle("-fx-background-image: url(\"background.jpg\");-fx-background-size: 1000 800;-fx-background-position: center center;");
        
        anchor.getChildren().add(pane);
        
        this.setContent(anchor);
        
        
        //test
        Docteur Doc1 = new Docteur();
        Doc1.setDocteur("Ca", 0, "Short","Ed", 023452432, "1321");
        Docteur Doc2 = new Docteur();
        Doc2.setDocteur("Ca", 0, "Moi","Oui Moi", 023452432, "1321");
        setDoctorResult(Doc1,Doc2);
    }
    
    public viewResult(controler c) {
        super();
        
        control = c;
    }

    public viewResult(Object[] tab) {
        this();
        
        this.tab = tab;
    }

    public void setControl(controler control) {
        this.control = control;
    }
    
    public void setDoctorResult(Docteur... docTab){
        tab = docTab;
        
        table.getColumns().clear();
        data.getChildren().clear();
        
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
        if(doc!=null){
            TextField nom,prenom,adresse,tel,spe;
            nom = new TextField();
            nom.setText(doc.getNomp());
            prenom = new TextField();
            prenom.setText(doc.getPrenomp());
            adresse = new TextField();
            adresse.setText(doc.getAdresse());
            tel = new TextField();
            tel.setText(String.valueOf(doc.getTel()));
            spe = new TextField();
            spe.setText(doc.getSpe());
            
            data.getChildren().addAll(new Label("Nom : "),nom,new Label("Prenom : "),prenom,new Label("Adresse : "),adresse,new Label("Telephone : "),tel,new Label("Specialite : "),spe);
            Button up = new Button("Update");
            up.setOnMouseClicked((event)->{
                control.updateDoc(doc.getNumero(),nom.getText(),prenom.getText(),adresse.getText(),tel.getText(),spe.getText());
            });
            data.getChildren().add(up);
            Button getP = new Button("Voir les Patients");
            getP.setOnMouseClicked((event)->{
                control.getPatientOf(doc.getNumero());
            });
            Button del = new Button("Supprimer");
            del.setOnMouseClicked((event)->{
                control.suppDocteur(doc.getNumero());
            });
            data.getChildren().addAll(getP,del);
        }
    }

    public void setInfirmierResult(Infirmier... infTab){
        tab = infTab;
        
        table.getColumns().clear();
        data.getChildren().clear();
        
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
        if(inf!=null){
            TextField nom,prenom,adresse,salaire,tel,service;
            nom = new TextField();
            nom.setText(inf.getNomp());
            prenom = new TextField();
            prenom.setText(inf.getPrenomp());
            adresse = new TextField();
            adresse.setText(inf.getAdresse());
            salaire = new TextField();
            salaire.setText(String.valueOf(inf.getSalaire()));
            tel = new TextField();
            tel.setText(String.valueOf(inf.getTel()));
            service = new TextField();
            service.setText(inf.getService());
            
            data.getChildren().addAll(new Label("Nom : "),nom,new Label("Prenom : "),prenom,new Label("Adresse : "),adresse,new Label("Salaire : "),salaire,tel,service);
            Button up = new Button("Update");
            up.setOnMouseClicked((event)->{
                control.updateInf(inf.getNumero(),nom.getText(),prenom.getText(),adresse.getText(),tel.getText(),salaire.getText(),service.getText());
            });
            data.getChildren().add(up);
            
            Button del = new Button("Supprimer");
            del.setOnMouseClicked((event)->{
                control.suppInfirmier(inf.getNumero());
            });
            data.getChildren().add(del);
        }
    }
    
    public void setPatientResult(Patient... patTab){
        tab = patTab;
        
        table.getColumns().clear();
        data.getChildren().clear();
        
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
        if(pat!=null){TextField nom,prenom,adresse,mutuelle,tel;
            nom = new TextField();
            nom.setText(pat.getNomp());
            prenom = new TextField();
            prenom.setText(pat.getPrenomp());
            adresse = new TextField();
            adresse.setText(pat.getAdresse());
            tel = new TextField();
            tel.setText(String.valueOf(pat.getTel()));
            mutuelle = new TextField();
            mutuelle.setText(pat.getMutuelle());

            
            data.getChildren().addAll(new Label("Nom : "),nom,new Label("Prenom : "),prenom,new Label("Adresse : "),adresse,new Label("Telephone : "),tel,new Label("Mutuelle :"),mutuelle);
            Button up = new Button("Update");
            up.setOnMouseClicked((event)->{
                control.updatePat(pat.getNumero(),nom.getText(),prenom.getText(),adresse.getText(),tel.getText(),mutuelle.getText());
            });
            data.getChildren().add(up);
            if(pat.getHospital()!=null)data.getChildren().addAll(new Label("Service : "+pat.getHospital().getCodeService()),new Label("Chambre : "+pat.getHospital().getNumero_chambre()),new Label("Lit : "+pat.getHospital().getNumero_chambre()));
            
            Button getDoc = new Button("Voir le(s) Docteur(s)");
            getDoc.setOnMouseClicked((event)->{
                control.getDoctorOf(pat.getNumero());
            });
            Button del = new Button("Supprimer");
            del.setOnMouseClicked((event)->{
                control.suppPatient(pat.getNumero());
            });
            data.getChildren().addAll(getDoc,del);
        }
    }
    
    public void setServiceResult(Service... servTab){
        tab = servTab;
        
        table.getColumns().clear();
        data.getChildren().clear();
        
        nomCol = new TableColumn("Code");
        prenomCol = new TableColumn("Nom");
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
        if(serv!=null)data.getChildren().addAll(new Label("Code : "+serv.getCode()),new Label("Nom : "+serv.getNom()),new Label("Batiment : "+serv.getBatiment()),new Label("Directeur : "+serv.getDirecteur()));
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
