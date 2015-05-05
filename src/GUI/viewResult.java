/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Jack
 */
public class viewResult extends View{

    Object[] tab;

    public viewResult() {
    }

    public viewResult(Object[] tab) {
        this.tab = tab;
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
