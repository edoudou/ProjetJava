/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Robin
 */
public class viewReporting extends View{
    PieChart serviceStat = new PieChart();
    
    
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    XYChart.Series docSerie = new XYChart.Series();
    
    BarChart<String,Number> doctorStat =  new BarChart<String,Number>(xAxis,yAxis);
    
    public viewReporting(){
        super();
        
        serviceStat.setTitle("Patient par service");
        serviceStat.getData().addAll(new PieChart.Data("Poires", 25),new PieChart.Data("Poires", 25),new PieChart.Data("Poires", 25));
        
        doctorStat.setTitle("Patient par docteur");
        xAxis.setLabel("Docteur");
        yAxis.setLabel("Nombre");
        
        
        docSerie.getData().addAll(new XYChart.Data("Eddy",25),
                new XYChart.Data("Moi",25),
                new XYChart.Data("Toi",35),
                new XYChart.Data("Lui",15));
        doctorStat.getData().add(docSerie);
 
        content.getChildren().addAll(serviceStat,doctorStat);
        content.setPadding(new Insets(20, 150, 290, 150));
        content.setStyle("-fx-background-image: url(\"background.jpg\");-fx-background-size: 2000 1600;-fx-background-position: center center;");
        
        this.setContent(content);
    }
    
    public void serviceStatClear(){
        serviceStat.getData().clear();
    }
    
    public void serviceStatAdd(String txt,int i){
        serviceStat.getData().add(new PieChart.Data(txt,i));
    }
    
    public void doctorStatClear(){
        docSerie.getData().clear();
    }
    
    public void doctorStatAdd(String txt,int i){
        docSerie.getData().add(new XYChart.Data(txt,i));
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
