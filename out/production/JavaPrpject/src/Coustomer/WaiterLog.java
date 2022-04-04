package Coustomer;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mkyong.Main;
import mkyong.ManagerSignin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WaiterLog {
   public void WaiterLogin(){
        ManagerSignin managerSignin = new ManagerSignin();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        Stage stage = new Stage();
        stage.setTitle("Sign in ");
        stage.setWidth(1024);
        stage.setHeight(760);
        AnchorPane root = new AnchorPane();
        Label name = new Label("username");
        Label pass = new Label("password");
        name.setTextFill(Color.web("#0076a3"));
       pass.setTextFill(Color.web("#0076a3"));

       TextField nametext =new TextField();nametext.setPromptText("Username");
        TextField passtext =new PasswordField();passtext.setPromptText("Password");
        ImageView view = new ImageView("Coustomer/waiter1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        name.setLayoutX(293-100-50);
        name.setLayoutY(176);
        nametext.setLayoutX(403-100-50);
        nametext.setLayoutY(176);
        pass.setLayoutX(288-100-50);
        pass.setLayoutY(234);
        passtext.setLayoutX(403-100-50);
        passtext.setLayoutY(234);
       pass.setFont(new Font(15));
       name.setFont(new Font(15));
        Button button = new Button("Enter");
       Button back=new Button("return");
       back.setLayoutX(934);
       back.setLayoutY(17);
       back.setOnAction((ActionEvent e)->{
           Main main=new Main();
           main.start(stage);
           stage.close();
       });
        root.getChildren().addAll(view, name, nametext, pass, passtext,button,back);

        button.setOnAction((ActionEvent e) ->{
            if (nametext.getText().isEmpty() || passtext.getText().isEmpty()){
                alert.setContentText("All fields required");
                alert.show();
            }
            CoustomerView coustomerView=new CoustomerView();

            if (this.checkUserName(nametext.getText(),passtext.getText())){
                coustomerView.menu();
                stage.close();
            }

            else {alert.setContentText("The username or the password are not match");alert.show();}
        });
        button.setLayoutX(490-50);
        button.setLayoutY(233);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    boolean checkUserName(String k,String v){
        File file=new File("Waiterslog.txt");
        File file1=new File("WriteUser.txt");
        try{
            FileWriter fileWriter=new FileWriter(file1);

        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();

        Scanner scanner=new Scanner(file);
        while (scanner.hasNext()){
            int d=scanner.nextInt();
            hashMap.put(scanner.next(),scanner.next());}
            if (hashMap.containsKey(k) && hashMap.get(k).compareTo(v)==0){
                fileWriter.write(k);
                fileWriter.close();
                return true;

        }}catch (IOException e){
            e.printStackTrace();
        }


        return false;
}


}
