/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Jack
 */
abstract class View extends ScrollPane implements viewInterface{
    private String name;
    private Object[] tab;
    private Button add,search;

    public View(String name, Button add, Button search,Object[] tab) {
        super();
        this.name = name;
        this.tab = tab;
        this.add = add;
        this.search = search;
    }
    public View(String name,Object... tab) {
        super();
        this.name = name;
        this.tab = tab;
        this.add = new Button("Add");
        this.search = new Button("Search");
    }

    public Object[] getTab() {
        return tab;
    }
    
    public Object getTabAtIndex(int i) {
        return tab[i];
    }

    public void setTab(Object[] tab) {
        this.tab = tab;
    }
    
    public void addToTab(Object... component){
        Object[] tab_bis = tab;
        
        int n = tab_bis.length;
        int k = component.length;
        tab = new Object[n+k];
        
        for(int i = 0; i < n;i++)
            tab[i] = tab_bis[i];
        
        for(int i = 0; i < k;i++)
            tab[n+i] = component[i];
    }

    public Button getAddButton() {
        return add;
    }

    public void setAddButton(Button add) {
        this.add = add;
    }
    
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
