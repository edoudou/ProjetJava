/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jack
 */
abstract class View extends ScrollPane implements viewInterface{
    protected String name;
    protected VBox content;

    
    public View() {
        content = new VBox();
    }
}
