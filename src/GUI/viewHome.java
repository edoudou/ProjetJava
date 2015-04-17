/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jack
 */
public class viewHome extends View{

    public viewHome() {
        super();
        name = "Home";
        
        this.setContent(content);
    }
    
    public viewHome(String name) {
        super();
        this.name = name;
        
        this.setContent(content);
        
    }
    
    public viewHome(String name,String url) {
        super();
        this.name = name;
        ImageView myImg = new ImageView(new Image(url));
        myImg.setFitHeight(this.getHeight());
        content.getChildren().add(myImg);
        this.setContent(content);
    }
    
}
