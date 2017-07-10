package sample;

import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;

/**
 * Created by Sadiqur Rahman on 5/19/2016.
 */
public class AddLight {
   public AddLight(Group root){
        PointLight light=new PointLight(Color.WHITE);
        light.setTranslateX(500);
        light.setTranslateY(350);
        light.setTranslateZ(-500);
        root.getChildren().addAll(light);
    }
}
