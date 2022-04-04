package mkyong;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Invoice {
    TableView<InvoiceTable> table;
    VBox vBox = new VBox();
    public void invoice() throws Exception {
        //ID
        Stage stage=new Stage();
        TableColumn<InvoiceTable, Integer> IDcolumn = new TableColumn<>("Bill Number");
        IDcolumn.setMinWidth(100);
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("Bill"));
// Name
        TableColumn<InvoiceTable, Integer> namecolumn = new TableColumn<>("Waiter ID");
        namecolumn.setMinWidth(100);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
// Surname
        TableColumn<InvoiceTable, Integer> surnamecolumn = new TableColumn<>("Amount");
        surnamecolumn.setMinWidth(100);
        surnamecolumn.setCellValueFactory(new PropertyValueFactory<>("Total"));



        table = new TableView<>();
        table.setItems(maketable());

        table.getColumns().addAll(IDcolumn, namecolumn, surnamecolumn);
    vBox.getChildren().addAll(table);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
    public ObservableList<InvoiceTable> maketable() throws NullPointerException {
        ObservableList<InvoiceTable> invoices = FXCollections.observableArrayList();
        try{

            File file=new File("Invoice.txt");
            Scanner scan=new Scanner(file);
            int i=0;
            if (file.length()==0){
              invoices.addAll(new InvoiceTable(0,0,0));
            }
            else {
            while(scan.hasNext()){


                    invoices.addAll(new InvoiceTable(Integer.parseInt(scan.next()),Integer.parseInt(scan.next()),Integer.parseInt(scan.next())));

            }

        }}catch (IOException e){
          e.printStackTrace();
        }

        return invoices;

    }

}
