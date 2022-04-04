package FoodMenu;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Apptisers extends Menu {
    TableView<MenuView> tableView;
    @Override
    public void SetMenu () {
        Stage primaryStage=new Stage();
        TableColumn<MenuView, Integer> idcolumn = new TableColumn<>("ID");
        idcolumn.setMinWidth(100);
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<MenuView, String> namecolumn = new TableColumn<>("Name");
        namecolumn.setMinWidth(100);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MenuView, String> desccolumn = new TableColumn<>("Description");
        desccolumn.setMinWidth(100);
        desccolumn.setCellValueFactory(new PropertyValueFactory<>("desc"));

        TableColumn<MenuView, Double> pricecolumn = new TableColumn<>("Price");
        pricecolumn.setMinWidth(100);
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<MenuView, Integer> caloriescolumn = new TableColumn<>("Calories");
        caloriescolumn.setMinWidth(100);
        caloriescolumn.setCellValueFactory(new PropertyValueFactory<>("cal"));


        tableView = new TableView<>();
        tableView.setItems(maketable());
        tableView.getColumns().addAll(idcolumn, namecolumn, desccolumn, pricecolumn, caloriescolumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableView);

        idnum.setLayoutX(544);
        idnum.setLayoutY(402);

        textField.setLayoutY(663);
        textField.setLayoutX(402);
        button.setLayoutX(700);
        button.setLayoutY(663);
        vBox.getChildren().addAll(idnum, button, textField);


        namemeal.setLayoutX(14);
        namemeal.setLayoutY(377);

        nametxt.setLayoutX(14);
        nametxt.setLayoutY(414);


        description.setLayoutX(125);
        description.setLayoutY(377);

        desctxt.setLayoutX(125);
        desctxt.setLayoutY(414);


        Price.setLayoutX(235);
        Price.setLayoutY(377);


        pricetxt.setLayoutX(235);
        pricetxt.setLayoutY(414);


        calories.setLayoutX(345);
        calories.setLayoutY(377);


        caloriestxt.setLayoutX(345);
        caloriestxt.setLayoutY(414);


        back.setLayoutX(934);
        back.setLayoutY(17);


        edit.setLayoutX(700);
        edit.setLayoutY(663);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                pricetxt.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d*")) {
                            pricetxt.setText(newValue.replaceAll("[^\\d]", ""));
                        }
                    }
                });
                caloriestxt.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d*")) {
                            caloriestxt.setText(newValue.replaceAll("[^\\d]", ""));
                        }
                    }
                });

            }
        });
        Alert alert = new Alert(Alert.AlertType.ERROR);
        button.setOnAction((ActionEvent e) -> {
            try {
                if (textField.getText().isEmpty() || textField.getText() == null){
                    alert.show();
                }
else {

                    File file = new File("src/FoodMenu/Apptisers.txt");
                    Scanner scan = new Scanner(file);

                    while (scan.hasNext()) {
                        linkedHash.put(Integer.parseInt(scan.next()), scan.next() + "\t" + scan.next() + "\t" + Double.parseDouble(scan.next()) + "\t" + Integer.parseInt(scan.next()));
                    }
                    if (linkedHash.containsKey(Integer.parseInt(textField.getText()))) {
                        vBox.getChildren().removeAll(idnum, textField, button);
                        vBox.getChildren().addAll(edit,namemeal, nametxt, description, desctxt, Price,pricetxt, calories, caloriestxt);

                        this.setTex(textField.getText());
                        nametxt.setText(na);
                        desctxt.setText(su);
                        pricetxt.setText(ad);
                        caloriestxt.setText(em);
                    } else {
                        alert.setContentText("the meal number is incorrect");
                        alert.show();
                    }
                }      } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        edit.setOnAction((ActionEvent r) -> {
            try {


                if (nametxt.getText().isEmpty() || desctxt.getText().isEmpty() || pricetxt.getText().isEmpty() || caloriestxt.getText().isEmpty()) {
                    alert.setContentText("All fields required");
                }
                File file = new File("src/FoodMenu/Apptisers.txt");
                linkedHash.replace(Integer.parseInt(textField.getText()), w.removeSpace(nametxt.getText()) + "\t" + w.removeSpace(desctxt.getText()) + "\t" + w.removeSpace(pricetxt.getText()) + "\t" + w.removeSpace(caloriestxt.getText()));
                FileWriter fileWriter = new FileWriter(file);

                linkedHash.forEach((k, v) -> {
                    try {
                        fileWriter.write(k + "\t" + v + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                fileWriter.close();
            } catch (IOException a) {
                a.printStackTrace();
            }
            tableView.setItems(maketable());
            vBox.getChildren().addAll(idnum, textField, button);
            vBox.getChildren().removeAll(namemeal, nametxt, edit, description, desctxt, pricetxt, Price, calories, caloriestxt);
            textField.setText("");
        });
        Scene scene = new Scene(vBox);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public ObservableList<MenuView> maketable () throws NullPointerException {
        ObservableList<MenuView> waiters = FXCollections.observableArrayList();

        try {


            File file = new File("src/FoodMenu/Apptisers.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                waiters.addAll(new MenuView(Integer.parseInt(scan.next()), scan.next(), scan.next(), Double.parseDouble(scan.next()), Integer.parseInt(scan.next())));
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("gr");
        }

        return waiters;

    }


    @Override
    void setTex(String x) throws IOException{
        File file=new File("src/FoodMenu/Apptisers.txt");
        Scanner scanner=new Scanner(file);
        while (scanner.hasNext()){
            if (scanner.next().compareTo(x)==0){
                na=scanner.next();
                su=scanner.next();
                ad=scanner.next();
                em=scanner.next();
            }
        }
    }
    }