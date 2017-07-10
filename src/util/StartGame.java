package util;

import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * Created by Sadiqur Rahman on 6/9/2016.
 */
public class StartGame {
  public   Button gameplay;
    public Button gamepause;
    Button start;
   public TextField text;
    Image image1;
    Image image2;
    Rectangle r;
    Rectangle r1;
    TextField name;
    TextField id;
    Rectangle gamewindow;
    String username;
    String userid;
    Image backg;

    public  StartGame(Group root){
        backg=new Image("sample\\pool.jpg");
        ImageView view=new ImageView(backg);
        view.setFitHeight(650);
        view.setFitWidth(1000);
        gameplay =new Button();
        gameplay.setText("Play");
        gameplay.setLayoutX(460);
        gameplay.setLayoutY(2);
        gameplay.setPrefWidth(50);
        gamepause =new Button();
        gamepause.setText("Pause");
        gamepause.setLayoutX(530);
        gamepause.setLayoutY(2);

        text=new TextField();
        text.setEditable(false);
        text.setLayoutX(300);
        text.setLayoutY(40);
        text.setPrefWidth(400);
        text.setPrefHeight(50);
        text.setAlignment(Pos.CENTER);
        text.setFont(Font.font(20));
        text.setText("WELCOME");
        Paint value0 = Paint.valueOf("#FFC0CB");
        TextField colorBox0;
        text.setBackground(new Background(new BackgroundFill(value0, CornerRadii.EMPTY, Insets.EMPTY)));
        r=new Rectangle(20,5,145,85);
        r1=new Rectangle(820,3,150,88);

        //gamewindow=new Rectangle(0,0,1000,650);

        start=new Button("Start");
        start.setLayoutX(485);
        start.setLayoutY(400);
        start.setFont(Font.font(20));
        name=new TextField();
        name.setFont(Font.font(18));
        name.promptTextProperty().setValue("User Name");
        name.setLayoutX(420);
        name.setLayoutY(250);
        id=new TextField();
        id.promptTextProperty().setValue("Numeric Facebook Id");
        id.setLayoutX(420);
        id.setLayoutY(300);
        id.setFont(Font.font(18));
        root.getChildren().addAll(view,name,id,start);

        start.setOnMouseClicked(event -> {
            //username=name.getText();
            userid=id.getText();
            root.getChildren().removeAll(name,id,start,view);
            root.getChildren().addAll(gameplay,gamepause,text,r,r1);
            setMyImage(userid);
        });
    }

    public void  start(Timeline game){
        gameplay.setOnMouseClicked(event -> {
            game.play();
        });
        gamepause.setOnMouseClicked(event -> {
            game.pause();
        });
    }

    public void setText(String tex){
        text.setText(tex);
    }

    public  void setMyImage(String name){

        if(name!=null) {
            image1 = new Image("https://graph.facebook.com/" +name+ "/picture?type=large");
            PhongMaterial p = new PhongMaterial();
            p.setDiffuseMap(image1);
            r.setFill(new ImagePattern(image1));
        }
    }
    public  void setOpImage(String name){
        if(name!=null) {
            image2 = new Image("https://graph.facebook.com/" + name + "/picture?type=large");
            PhongMaterial p = new PhongMaterial();
            p.setDiffuseMap(image2);
            r1.setFill(new ImagePattern(image2));
        }
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }
}
