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
public interface viewInterface{
    
    public void addToTab(GUIComponent... component);
    public void addToTab(GUIComponent component,String title);
    public void setAddButtonListener(EventHandler<ActionEvent> actionToPerform);
    public void setSearchButtonListener(EventHandler<ActionEvent> actionToPerform);
}
