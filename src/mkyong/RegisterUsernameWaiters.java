package mkyong;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class RegisterUsernameWaiters extends Table {
    public void register () {
        Stage stage=new Stage();
        // ManagerSignin managerSignin = new ManagerSignin();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        stage.setTitle("Register Waiters");
        stage.setWidth(1024);
        stage.setHeight(760);
        AnchorPane root = new AnchorPane();
        TextField IDtxt = new TextField();
        TextField nametext = new TextField();
        TextField passtext = new PasswordField();
        IDtxt.setPromptText("ID Number");
        nametext.setPromptText("Name");
        passtext.setPromptText("password");
        ImageView view = new ImageView("mkyong/manager1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        nametext.setLayoutX(403-100);
        nametext.setLayoutY(176);
        passtext.setLayoutX(403-100);
        passtext.setLayoutY(234);
        IDtxt.setLayoutX(403-100);
        IDtxt.setLayoutY(290);
        IDtxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    IDtxt.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Button back=new Button("return");
        back.setLayoutX(800+100);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e)->{
            ManagerSignin a=new ManagerSignin();
            try {
                a.sec();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            stage.close();
        });
        Button button = new Button("Enter");
        button.setLayoutX(590-100);
        button.setLayoutY(233);
        root.getChildren().addAll( view, back, IDtxt, nametext, passtext, button);
        RegisterUsernameWaiters a=new RegisterUsernameWaiters();
        RegisterWaiter c=new RegisterWaiter();

        button.setOnAction((ActionEvent e) -> {
            try {
                if (nametext.getText().isEmpty() || passtext.getText().isEmpty())alert.show();

            if (!checkId(IDtxt.getText())) {
                alert.setContentText("The ID is Already has Username & Passwored");
                alert.show();
            }
                else if(c.ID(IDtxt.getText())){
                    alert.setContentText("The ID is not exist ");
                    alert.show();
                }
                else if(!checkIFsuitable(passtext.getText(),Integer.parseInt(IDtxt.getText()))){
                    alert.setContentText("The password should has An Capital Letter at least");
                    alert.show();
            }


             else if(!a.checkUserName(nametext.getText(),passtext.getText())){
                alert.setContentText("The username or the password are already token");
                alert.show();
            }

            else {

                try{
                    File file = new File("Waiterslog.txt");
                    FileWriter write = new FileWriter(file, true);
                    write.write(Integer.parseInt(IDtxt.getText()) + "\t");
                    write.write(nametext.getText() + "\t");
                    write.write(passtext.getText() + "\n");
                    write.close();
                    nametext.setText("");
                    IDtxt.setText("");
                    passtext.setText("");
                    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                    alert1.setContentText("The Waiters been Added Successfully");alert1.show();
                }catch(IOException ex){
                    ex.printStackTrace();}
            }
            }catch (IOException c1){
                c1.printStackTrace();
            }
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public boolean checkUserName(String key, String value) throws NullPointerException{
        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();

        File file=new File("Waiterslog.txt");
        try{     Scanner scan=new Scanner(file);
            while (scan.hasNext()) {
            int id=scan.nextInt();
            String user=scan.next();
            String pas=scan.next();
                hashMap.put(user, pas);
            } }catch (IOException e){
            e.printStackTrace();
        }
        if (hashMap.containsKey(key)){return false;}



        return true;
    }
    private boolean checkIFsuitable(String value,int ID) {
        File file=new File("Waiterslog.txt");
        try{  Scanner scan=new Scanner(file);
            while (scan.hasNext()){
                if (scan.next().compareTo(String.valueOf(ID))==0 ){
                    if (value.compareTo(scan.next())==0)
                 return false;}
            }
              for (int i = 0; i < value.length(); i++) {
                if (Character.isAlphabetic(value.charAt(i))){
                    return true;

                }
                else return false;
            }

        }catch (IOException e){
            e.printStackTrace();
        }        return true;
    }

     void delete(String ID) throws IOException {
        File file=new File("Waiterslog.txt");
        Scanner scan=new Scanner(file);
         HashMap<String,String> arrayList=new HashMap<>();
         while (scan.hasNext()) {
             arrayList.put(scan.next(),scan.next()+"\t"+scan.next());
         }
         arrayList.remove(ID);
         FileWriter writer=new FileWriter(file);writer.write("");writer.close();
         FileWriter writer1=new FileWriter(file,true);
         arrayList.forEach((k,v)->{
             try {
                 writer1.write(k+"\t"+v+"\n");
             } catch (IOException e) {
                 e.printStackTrace();
             }
         });writer1.close();
     }
boolean checkId(String x) throws IOException{
    File file1 = new File("WaitersLog.txt");

        Scanner scan = new Scanner(file1);
        while (scan.hasNext()) {
            if (x.compareTo(scan.next()) == 0) {
                return false;
            }

        }
 return true;
}


}



