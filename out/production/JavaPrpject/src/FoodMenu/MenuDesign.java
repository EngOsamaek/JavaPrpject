package FoodMenu;

import Coustomer.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mkyong.ManagerSignin;

import java.io.FileNotFoundException;

public class MenuDesign {
public void mainPage(int i){
Alert alert=new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();
    stage.setResizable(false);
    stage.setTitle("Menu main");
    stage.setWidth(1024);
    stage.setHeight(760);
    stage.setResizable(false);
    ImageView view = new ImageView("FoodMenu/MenuPane.png");
    view.setFitWidth(1024);
    view.setFitHeight(760);
    AnchorPane root = new AnchorPane();
    Button MainCourses=new Button("Main Courses");
    MainCourses.setLayoutX(238);
    MainCourses.setLayoutY(109);
    MainCourses.prefWidth(25);
    MainCourses.prefHeight(25);
    ImageView c=new ImageView("FoodMenu/anatolir190300290.jpg");
    c.prefHeight(25);
    c.prefWidth(25);
    c.setFitHeight(50);
    c.setFitWidth(50);
    MainCourses.setGraphic(c);
    MainCourses.setOnAction((ActionEvent e)-> {
          if (i==1){this.poly(1);}
        else if(i==2){
              MainMealCoust mealCoust=new MainMealCoust();
              mealCoust.menu();

          }
        else {alert.setContentText("error in sending parameter");alert.show();
          }
    });
    Button Desserts=new Button("Desserts");
    Desserts.setLayoutX(48);
    Desserts.setLayoutY(220);
    Desserts.prefWidth(25);
    Desserts.prefHeight(25);
    ImageView vw=new ImageView("FoodMenu/ing_19020_02200.jpg");
    vw.prefWidth(25);
    vw.prefHeight(25);
    vw.setFitWidth(50);
    vw.setFitHeight(50);
    Desserts.setGraphic(vw);
    Desserts.setOnAction((ActionEvent e)->{
    if (i==1) {
        this.poly(3);
    }
    else if (i==2){
        DessertsCoust dessertsCoust=new DessertsCoust();
        dessertsCoust.menu();
    }
    else alert.show();
    });



    Button appetizers=new Button("Appetizers");
    appetizers.setLayoutX(249);
    appetizers.setLayoutY(220);
    ImageView view1=new ImageView("FoodMenu/hand-drawn-bowl-full-of-crispy-potato-eps-vector_csp51149046.jpg");
    view1.prefHeight(25);
    view1.prefWidth(25);
    view1.setFitHeight(50);
    view1.setFitWidth(50);
    appetizers.prefHeight(10);
    appetizers.prefWidth(10);
    appetizers.setGraphic(view1);
    appetizers.setOnAction((ActionEvent e)->{
        try {
           if (i==1){
               this.poly(2);
           }
           else if(i==2){
               Apptizers apptizers=new Apptizers();
               apptizers.menu();
           }
           else alert.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    });
    Button drinks=new Button("Drinks");
    drinks.setLayoutX(48);
    drinks.setLayoutY(109);
    Image image=new Image("FoodMenu/kawaii-fast-food-cute-drinks-illustration_24908-60622.jpg");
    ImageView imageView=new ImageView(image);
    imageView.setFitWidth(25);
    imageView.setFitHeight(25);
    drinks.prefHeight(25);
    drinks.prefWidth(25);
    imageView.setFitWidth(50);
    imageView.setFitHeight(50);
    drinks.setGraphic(imageView);
    drinks.setOnAction((ActionEvent e)->{
        try {if (i==1){
           this.poly(4);}
           else if (i==2){
            DrinksCoust drinksCoust=new DrinksCoust();
            drinksCoust.menu();

        }
           else alert.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    });

    Button back=new Button("return");
    back.setLayoutX(934);
    back.setLayoutY(17);
    back.setOnAction((ActionEvent e)->{
        CoustomerView coustomerView=new CoustomerView();
        if (i==1){
            ManagerSignin managerSignin=new ManagerSignin();
            try {
                managerSignin.sec();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            stage.close();}
        if (i==2){
            coustomerView.menu();
            stage.close();
        }
    });
    root.getChildren().addAll(view, appetizers,back,Desserts,MainCourses,drinks);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
void poly(int i){
    Menu menu=null;
    if (i==1){
        menu=new MainMeals();
    }
    else if (i==2){
        menu=new Apptisers();
    }
    else if (i==3){
        menu=new Desserts();
    }
    else if(i==4){
        menu=new Drinks();
    }
    else {
        Alert alert=new Alert(Alert.AlertType.ERROR);alert.show();
    }

    if (menu != null) {
        menu.SetMenu();
    }

}

}

