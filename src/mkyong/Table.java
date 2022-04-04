package mkyong;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Table  { /////////////////////////////make all gui objects in the parent class/////////////////////////7@@@@@@@@
    TableView<WaitersInfo> table;
    VBox vBox = new VBox();
    public void start() throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Waiters table");
        //ID
        TableColumn<WaitersInfo, String> IDcolumn = new TableColumn<>("ID");
        IDcolumn.setMinWidth(100);
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
// Name
        TableColumn<WaitersInfo, String> namecolumn = new TableColumn<>("Name");
        namecolumn.setMinWidth(100);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
// Surname
        TableColumn<WaitersInfo, String> surnamecolumn = new TableColumn<>("Surname");
        surnamecolumn.setMinWidth(100);
        surnamecolumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        //Address
        TableColumn<WaitersInfo, String> Addresscolumn = new TableColumn<>("Address");
        Addresscolumn.setMinWidth(200);
        Addresscolumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Email
        TableColumn<WaitersInfo, String> Emailcolumn = new TableColumn<>("Email");
        Emailcolumn.setMinWidth(100);
        Emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Number
        TableColumn<WaitersInfo, String> Numbercolumn = new TableColumn<>("Number");
        Numbercolumn.setMinWidth(120);
        Numbercolumn.setCellValueFactory(new PropertyValueFactory<>("number"));


        table = new TableView<>();
        table.setItems(maketable());

        table.getColumns().addAll(IDcolumn, namecolumn, surnamecolumn, Addresscolumn, Emailcolumn, Numbercolumn);

        Label idnum = new Label("enter the ID number");
        idnum.setTextFill(Color.web("#0076a3"));
        idnum.setLayoutX(544);
        idnum.setLayoutY(402);

        TextField textField = new TextField();
        textField.setLayoutY(663);
        textField.setLayoutX(402);
        Button button = new Button("search");

        button.setLayoutX(700);
        button.setLayoutY(663);
//////////////////////////////////////////////////////////////
        Label name = new Label("Name");
        name.setLayoutX(14);
        name.setLayoutY(377);
        TextField nametxt = new TextField();
        nametxt.setLayoutX(14);
        nametxt.setLayoutY(414);

        Label surname = new Label("Surname");
        surname.setTextFill(Color.web("#0076a3"));
        surname.setLayoutX(125);
        surname.setLayoutY(377);

        TextField surnametxt = new TextField();
        surnametxt.setLayoutX(125);
        surnametxt.setLayoutY(414);


        Label address = new Label("Address");
        address.setLayoutX(235);
        address.setLayoutY(377);
        address.setTextFill(Color.web("#0076a3"));


        TextField addresstxt = new TextField();
        addresstxt.setLayoutX(235);
        addresstxt.setLayoutY(414);


        Label email = new Label("Email");
        email.setLayoutX(345);
        email.setLayoutY(377);


        TextField emailtxt = new TextField();
        emailtxt.setLayoutX(345);
        emailtxt.setLayoutY(414);


        Label number = new Label("Number");
        number.setLayoutX(455);
        number.setLayoutY(377);


        TextField numbertxt = new TextField();
        numbertxt.setLayoutX(455);
        numbertxt.setLayoutY(414);
        Button delete=new Button("Delete");

        Button edit=new Button("Update");
        vBox.getChildren().addAll(table, delete, button, textField);
        edit.setLayoutX(700);
        edit.setLayoutY(663);
        textField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        textField.setPromptText("ID number");
        Alert alert=new Alert(Alert.AlertType.ERROR);
        delete.setLayoutX(770);
        delete.setLayoutY(663);
        RegisterWaiter c=new RegisterWaiter();
        RegisterUsernameWaiters a=new RegisterUsernameWaiters();
        button.setOnAction((ActionEvent e) -> {
            if (textField.getText().isEmpty()){alert.setContentText("Enter the ID number \uD83D\uDE24\uD83D\uDE24");alert.show();}

            if (!c.ID(textField.getText())){
                nametxt.setText(c.getNm());
                surnametxt.setText(c.getSur());
                addresstxt.setText(c.getAd());
                emailtxt.setText(c.getEm());
                numbertxt.setText(c.getN());
                vBox.getChildren().removeAll(delete,idnum, textField,button);
                vBox.getChildren().addAll(edit,name, nametxt, surname, surnametxt, email, emailtxt, number, numbertxt,address,addresstxt);}
            else {
                alert.show();
            }
        });
        delete.setOnAction((ActionEvent e)->{
            table.setItems(maketable());
        if (c.ID(textField.getText())){
            alert.setContentText("The ID is not exist");
            alert.show();
        }

        else {
            try {
                a.delete(textField.getText());
                this.delete(textField.getText());
                table.setItems(maketable());

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        });
        edit.setOnAction((ActionEvent e)->{
            try {
                if (nametxt.getText().isEmpty() || surnametxt.getText().isEmpty() || emailtxt.getText().isEmpty() || numbertxt.getText().isEmpty() || addresstxt.getText().isEmpty()){
                    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("All field are required");
                }

                File file = new File("WaitersData.txt");
                Scanner scan = new Scanner(file);
                HashMap<Integer,String> arrayList = new HashMap<>();
                while (scan.hasNext() || scan.hasNextInt()) {
                    arrayList.put(scan.nextInt(),scan.next()+"\t"+scan.next()+"\t"+scan.next()+"\t"+scan.next()+"\t"+scan.next());
                    if (arrayList.containsKey(Integer.valueOf(textField.getText()))){
                        arrayList.replace(Integer.parseInt(textField.getText()),this.removeSpace(nametxt.getText())+"\t"+this.removeSpace(surnametxt.getText())+"\t"+this.removeSpace(addresstxt.getText())+"\t"+this.removeSpace(emailtxt.getText())+"\t"+this.removeSpace(numbertxt.getText()));
                    }
                    if (!scan.hasNext()){
                        FileWriter writer=new FileWriter(file);
                        writer.write("");
                        writer.close();
                        FileWriter writer1=new FileWriter(file,true);
                        arrayList.forEach((k,v)->{
                            try {
                                writer1.write(k+"\t"+v+"\n");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }


                        });

                        writer1.close();
                        arrayList.clear();
                    }
                }}catch (IOException d){
                d.printStackTrace();
            }       table.setItems(maketable());
            textField.setText("");
            vBox.getChildren().addAll(delete,idnum, textField,button);
            vBox.getChildren().removeAll(edit,name, nametxt, surname, surnametxt, email, emailtxt, number, numbertxt,address,addresstxt);});

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<WaitersInfo> maketable() throws NullPointerException {
        ObservableList<WaitersInfo> waiters = FXCollections.observableArrayList();
        try{

            File file=new File("WaitersData.txt");
            Scanner scan=new Scanner(file);
            int i=0;

            while(scan.hasNextInt()||scan.hasNext()){
                if (file.length()==0){
                    waiters.addAll(new WaitersInfo(0," "," "," "," "," "));
break;
                }
                else
                waiters.addAll(new WaitersInfo(scan.nextInt(),scan.next(),scan.next(),scan.next(),scan.next(),scan.next()));

            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return waiters;

    }

private void delete(String ID) throws IOException {
        File file=new File("WaitersData.txt");
        Scanner scan=new Scanner(file);

        HashMap<String,String> arrayList=new HashMap<>();
        while (scan.hasNext()) {
            arrayList.put(scan.next(),scan.next()+"\t"+scan.next()+"\t"+scan.next()+"\t"+scan.next()+"\t"+scan.next());
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
public StringBuilder removeSpace(String name1){
    StringBuilder name=new StringBuilder(name1);
        for (int i=0;i<name.length();i++){
        if (name.charAt(i)==' '){
            name.setCharAt(i,'-');
        }
    }
    return name;
}
}




