package Coustomer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DessertsCoust implements WaiterMenu {
    @Override
    public void menu(){
        Stage stage=new Stage();
        stage.setResizable(false);
        stage.setTitle("Meenu page");
        stage.setWidth(950);
        stage.setHeight(760);
        stage.setResizable(false);
        ImageView view = new ImageView("https://thumbs.dreamstime.com/z/menu-restaurant-old-paper-background-vector-illustration-111773277.jpg");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(view);

        Label label1=new Label();
        label1.setLayoutX(55);
        label1.setLayoutY(21);
        CheckBox box1=new CheckBox("Add");
        box1.setLayoutX(170);
        box1.setLayoutY(21);
        TextField textField1=new TextField();
        textField1.setLayoutX(90);
        textField1.setLayoutY(100);
        Label[] labels=new Label[5];
        Label[] textField=new Label[5];
        CheckBox[]boxes=new CheckBox[5];

        Button add=new Button("Add");
        add.setLayoutY(377);
        add.setLayoutX(486+40+50+70);
        double x=label1.getLayoutX();
        double y=label1.getLayoutY();
        double yy=textField1.getLayoutY();
        double yyy=box1.getLayoutY();
        for (int i=0;i<4;i++) {
            textField[i]=new Label();
            y+=30;
            textField[i].setLayoutY(y+20+40+20+10);
            textField[i].setLayoutX(textField1.getLayoutX()-40);
            labels[i] = new Label();
            yy+=30;
            labels[i].setText("hi");
            labels[i].setLayoutX(x-40);
            labels[i].setLayoutY(yy-55+40+20+10);
            boxes[i]=new CheckBox("add");
            boxes[i].setLayoutX(box1.getLayoutX()+70);
            yyy+=30;
            boxes[i].setLayoutY(yyy+20+40+20+10);
            root.getChildren().addAll(boxes[i],labels[i],textField[i]);

        }
        File file1=new File("src/FoodMenu/Desserts.txt");
        try {int i=0;
            Scanner scan=new Scanner(file1);
            while (scan.hasNext()){
                Integer a=Integer.parseInt(scan.next())+1;
                String b=scan.next();
                String c=scan.next();
                String d=scan.next();
                String e=scan.next();

                labels[i].setText(String.valueOf(a));
                textField[i].setText(b+"  "+e+"cal"+"  "+d+"TL");
                i++;
                if (i==10 )break;

            }

        }catch (IOException e){
            e.printStackTrace();
        }
        int b=0;

        ChoiceBox<Integer> choiceBox=new ChoiceBox<>();
        label1.setText("CHOOSE THE TABLE NUMBER!!");
        label1.setLayoutX(340);
        label1.setLayoutY(382);
        choiceBox.setLayoutX(486+40);
        choiceBox.setLayoutY(377);
        choiceBox.setPrefHeight(25);
        choiceBox.setPrefWidth(85);
        choiceBox.getItems().add(1);
        choiceBox.getItems().add(2);
        choiceBox.getItems().add(3);
        choiceBox.getItems().add(4);

        add.setOnAction((ActionEvent e)->{
            if (choiceBox.getSelectionModel().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Choose the Table please");
                alert.show();
            }
            else {
                handleOptions(boxes, getbox(choiceBox));
                Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                alert1.setContentText("The items been added \uD83D\uDC69\uD83C\uDFFC\u200D\uD83C\uDF73");
                  alert1.show();
            }});

        Button back=new Button("return");
        back.setLayoutX(934);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e)->{
            //   ManagerSignin managerSignin=new ManagerSignin();
            // managerSignin.sec();
            //stage.close();
        });
        root.getChildren().addAll( back,add,choiceBox,label1);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @Override
    public void handleOptions(CheckBox[] boxes, int z) {
        int os = 0;
        String address=null;
        if (z==1){
            address="table1.txt";
        }
        else if(z==2){
            address="table2.txt";

        }
        else if(z==3){
            address="table3.txt";

        }
        else if (z==4){
            address="table4.txt";

        }
        else {
            address="table1.txt";
        }
        for (int i=0;i<4;i++){
            if (boxes[i].isSelected())
            {boxes[i].setSelected(false);
                try {os=0;


                    File file = new File(address);
                    FileWriter writer = new FileWriter(file, true);
                    File file1=new File("src/FoodMenu/Desserts.txt");
                    Scanner scan = new Scanner(file1);
                    while (scan.hasNext()) {
                        Integer a = Integer.parseInt(scan.next()) + 1;
                        String b = scan.next();
                        String c = scan.next();
                        String d = scan.next();
                        String e = scan.next();
                        if (os == i) {
                            writer.write(b+ "\t" + d+"\n");

                        }                        os++;

                    }                            writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }}
        @Override
    public int getbox(ChoiceBox<Integer> choiceBox){
        return choiceBox.getValue();
    }
}

