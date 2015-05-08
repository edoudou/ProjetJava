/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jack
 */
public class viewSearch extends View{
    
    private GUIComponent[] tab;
    private Button add,search;
    protected VBox bottomContent;

    public viewSearch() {
        super();
        this.add = new Button("Add");
        this.search = new Button("Search");
        
        bottomContent = new VBox();
        
        bottomContent.getChildren().addAll(add,search);
        
        BorderPane layout = new BorderPane();
        
        layout.setCenter(content);
        layout.setBottom(bottomContent);
        
        this.setContent(layout);
    }
    
    public viewSearch(String name, Button add, Button search,GUIComponent[] tab) {
        super();
        this.name = name;
        this.tab = tab;
        this.add = add;
        this.search = search;
        
        content.getChildren().add(add);
        content.getChildren().add(search);
    }
    
    public viewSearch(String name, Button add, Button search,Object[] tab) {
        super();
        this.name = name;
        for(int i = 0;i < tab.length;i++)
            this.tab[i] = new GUIComponent(tab[i],"");
        
        this.add = add;
        this.search = search;
        
        content.getChildren().add(add);
        content.getChildren().add(search);
    }
    
    public viewSearch(String name,Object... tab) {
        super();
        this.name = name;
        for(int i = 0;i < tab.length;i++)
            this.tab[i] = new GUIComponent(tab[i],"");
        this.add = new Button("Add");
        this.search = new Button("Search");
    }

    public GUIComponent[] getTab() {
        return tab;
    }
    
    public GUIComponent getTabAtIndex(int i) {
        return tab[i];
    }
    
    public GUIComponent getTabNamed(String name) {
        for (GUIComponent tab1 : tab) {
            if (tab1.getTitle().equals(name)) {
                return tab1;
            }
        }
        
        return null;
    }

    public void setTab(GUIComponent[] tab) {
        this.tab = tab;
    }
    
    @Override
    public void addToTab(GUIComponent... component){
        int n;
        GUIComponent[] tab_bis = tab;
        int k = component.length;
        
        if(tab_bis != null){
            n = tab_bis.length;    
        }
        else n =0;
        
        
        tab = new GUIComponent[n+k];
        
        for(int i = 0; i < n;i++)
                tab[i] = tab_bis[i];
        
        for(int i = 0; i < k;i++){
            tab[n+i] = component[i];
            content.getChildren().add(new Label(tab[n+i].getTitle() + " :"));
            content.getChildren().add((Node)tab[n+i].getData());
        }
        
    }
    
    public void addToTab(Object component,String title){
        GUIComponent[] tab_bis = tab;
        
        int n = tab_bis.length;
        tab = new GUIComponent[n + 1];
        
        for(int i = 0; i < n;i++)
            tab[i] = tab_bis[i];
        
        
        tab[n+1] = new GUIComponent(component,title);
    }

    public Button getAddButton() {
        return add;
    }

    public void setAddButton(Button add) {
        this.add = add;
    }
    
    @Override
    public void setAddButtonListener(EventHandler<ActionEvent> actionToPerform){
        add.setOnAction(actionToPerform);
    }

    public Button getSearchButton() {
        return search;
    }

    public void setSearchButton(Button search) {
        this.search = search;
    }
    
    public void setSearchButtonListener(EventHandler<ActionEvent> actionToPerform){
        search.setOnAction(actionToPerform);
    }
    
}
