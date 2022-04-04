package mkyong;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
public class RegisterWaiter {
    int Ref ;    private String nm,sur,ad,em,n;

    void setData() throws NullPointerException {
        RegisterWaiter a=new RegisterWaiter();
        Stage stage = new Stage();
        stage.setTitle("Sign in ");
        stage.setWidth(1024);
        stage.setHeight(760);
        AnchorPane root = new AnchorPane();
        Button back=new Button("Return");
        back.setLayoutX(934);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e)->{
            ManagerSignin managerSignin=new ManagerSignin();
            try {
                managerSignin.sec();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            stage.close();
        });
        Label name = new Label("Name");
        Label surname = new Label("surname");
        Label email=new Label("Email");
        Label number=new Label("number");
        Label address=new Label("Address");
        TextField nametext = new TextField();
        TextField surnametxt = new TextField();
        TextField emailtxt=new TextField();
        TextField numbertxt=new TextField();
        TextField addresstxt=new TextField();
        ImageView view = new ImageView("mkyong/manager1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        name.setLayoutX(14);
        name.setLayoutY(14);
        nametext.setLayoutX(134);
        nametext.setLayoutY(14);
        surname.setLayoutX(14);
        surname.setLayoutY(73);
        surnametxt.setLayoutX(134);
        surnametxt.setLayoutY(73);
        email.setLayoutX(14);
        email.setLayoutY(132);
        emailtxt.setLayoutX(134);
        emailtxt.setLayoutY(132);
        number.setLayoutX(14);
        number.setLayoutY(201);
        numbertxt.setLayoutX(134);
        numbertxt.setLayoutY(201);
        address.setLayoutX(14);
        address.setLayoutY(200);
        addresstxt.setLayoutX(134);
        addresstxt.setLayoutY(200);
        number.setLayoutX(14);
        number.setLayoutY(260);
        numbertxt.setLayoutX(134);
        numbertxt.setLayoutY(260);
        Button button = new Button("Add new waiter/s");
        button.setLayoutX(150+70+80);
        button.setLayoutY(15);
        name.setFont(new Font(15));
        surname.setFont(new Font(15));
        address.setFont(new Font(15));
        email.setFont(new Font(15));
        number.setFont(new Font(15));
        name.setTextFill(Color.web("#0076a3"));
        surname.setTextFill(Color.web("#0076a3"));
        email.setTextFill(Color.web("#0076a3"));
        address.setTextFill(Color.web("#0076a3"));
        number.setTextFill(Color.web("#0076a3"));

        root.getChildren().addAll(view, button,name, nametext,surname,surnametxt,email,emailtxt,address,addresstxt,number,numbertxt,back);

        button.setOnAction((ActionEvent e)->{
            try {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                ManagerSignin managerSignin=new ManagerSignin();
                    do {
                       this.Ref=managerSignin.SetRef();
                    } while (!a.ID(String.valueOf(managerSignin.SetRef())));
                File info=new File("WaitersData.txt");
                FileWriter writer=new FileWriter(info,true);

                PrintWriter printWriter=new PrintWriter(writer);
                if (nametext.getText().equals(null) || surnametxt.getText().equals(null) || emailtxt.getText().equals(null) || addresstxt.getText().equals(null) || numbertxt.getText().equals(null)){
                    alert.show();
                }
                else if(nametext.getText().isEmpty() || surnametxt.getText().isEmpty() || emailtxt.getText().isEmpty() || addresstxt.getText().isEmpty() || numbertxt.getText().isEmpty()  ){
                    alert.show();
                }
                else {
                    Table r=new Table();
                printWriter.print(this.Ref);
                writer.write("\t"+r.removeSpace(nametext.getText()));
                writer.write("\t"+r.removeSpace(surnametxt.getText()));
                writer.write("\t"+r.removeSpace(addresstxt.getText()));
                writer.write("\t"+r.removeSpace(emailtxt.getText()));
                writer.write("\t"+r.removeSpace(numbertxt.getText())+"\n");
                    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                    alert1.setContentText("The Waiters been Added Successfully");alert1.show();
                nametext.setText("");
                surnametxt.setText("");
                emailtxt.setText("");
                numbertxt.setText("");
                addresstxt.setText("");
                    printWriter.close();
                    writer.close();}

            }catch (IOException p){
                p.printStackTrace();
            }
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
            stage.show();
    }



    public boolean ID(String i){
       try {
           File info = new File("WaitersData.txt");
           Scanner scan = new Scanner(info);
           while (scan.hasNext()){
            if (scan.next().compareTo(i)==0){
                this.nm=scan.next();
                this.sur=scan.next();
                this.ad=scan.next();
                this.em=scan.next();
                this.n=scan.next();
                return false;
            }

           }
       }catch (IOException e){
           e.printStackTrace();
       }
       return true;
   }

    public String getN() {
        return n;
    }

    public String getAd() {
        return ad;
    }

    public String getEm() {
        return em;
    }

    public String getNm() {
        return nm;
    }

    public String getSur() {
        return sur;
    }
}


