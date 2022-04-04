package Coustomer;

import FoodMenu.MenuDesign;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mkyong.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CoustomerView {
    Alert alert=new Alert(Alert.AlertType.ERROR);
   public void menu(){
   Stage stage=new Stage();
        stage.setTitle("Waiter View");
        stage.setWidth(1024);
        stage.setHeight(760);
        AnchorPane root = new AnchorPane();
        Button table1 = new Button();
        table1.setLayoutX(28);
        table1.setLayoutY(65);
        table1.setPrefHeight(75);
        table1.setPrefWidth(75);
        table1.setOnAction((ActionEvent e )->{
            MenuDesign menuDesign=new MenuDesign();
             menuDesign.mainPage(2);
             stage.close();
        });

        ImageView view1=new ImageView("src/Coustomer/MenuIcon.jpg");
     view1.setFitWidth(75);
     view1.setFitHeight(75);
     table1.setGraphic(view1);

       ChoiceBox<Integer> choiceBox=new ChoiceBox<>();
       choiceBox.setLayoutX(175);
       choiceBox.setLayoutY(65+30+60);
        choiceBox.getItems().add(1);
       choiceBox.getItems().add(2);
       choiceBox.getItems().add(3);
       choiceBox.getItems().add(4);
       Label label2=new Label("  ");
       label2.setLayoutY(95);
       label2.setLayoutX(150);
       Button table2 = new Button("Order bill");
        table2.setLayoutX(175);
        table2.setLayoutY(65);
        table2.setPrefHeight(91);
        table2.setPrefWidth(96);
        table2.setOnAction((ActionEvent e)->{
            File file=null;
            try {


                if (choiceBox.getSelectionModel().isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Choose the Table please");
                    alert.show();
                }



else {
                if (choiceBox.getValue() == 1) {
                    file = new File("table1.txt");
                }
                else if (choiceBox.getValue() == 2) {
                    file = new File("table2.txt");
                }
                else if (choiceBox.getValue() == 3){
                    file = new File("table3.txt");
                }
                else if (choiceBox.getValue() == 4){
                    file = new File("table4.txt");
                }
                else alert.show();
            }}catch (NullPointerException r){
                r.fillInStackTrace();
            }
            if (file != null) {
                if (file.length()>0){
                    Bill bill=new Bill();
                    try {
                        bill.bill(choiceBox.getValue());
                        FileWriter writer=new FileWriter(file);
                        writer.write("");
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    alert.setContentText("This table hasn't any orders");
                    alert.show();
                }
            }
        });



        ImageView view = new ImageView("Coustomer/waiter1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);


        Button back = new Button("return");
        back.setLayoutX(934);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e) -> {
            Main main = new Main();
            Stage pp=new Stage();
            main.start(pp);
            stage.close();
        });
        root.getChildren().addAll(view, back, table1, table2,choiceBox,label2);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
