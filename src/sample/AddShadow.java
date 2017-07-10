package sample;

import javafx.scene.effect.DropShadow;

/**
 * Created by Sadiqur Rahman on 5/20/2016.
 */
public class AddShadow {
    DropShadow d;
    AddShadow(Double offsetX,Double offsetY){
        d=new DropShadow();
        d.setOffsetX(offsetX);
        d.setOffsetY(offsetY);
    }
}
