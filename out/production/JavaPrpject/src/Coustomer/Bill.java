package Coustomer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Bill  {
   private int xy=0;
   static private int BillNumber=0;
   public void bill(int xx) throws IOException {
        Stage stage=new Stage();
        this.xy=xx;
        stage.setResizable(false);
        stage.setTitle("Bill page");
        stage.setWidth(950);
        stage.setHeight(760);
        stage.setResizable(false);
    ImageView view = new ImageView("Coustomer/O2 copy (1).png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
    AnchorPane root = new AnchorPane();
        root.getChildren().addAll(view);
    Label label1=new Label();
        label1.setLayoutX(55);
        label1.setLayoutY(21);
    TextField textField1=new TextField();
        textField1.setLayoutX(90);
        textField1.setLayoutY(100);
    Label[]labels=new Label[20];
    Label[] labl=new Label[20];
    Label[] labels1=new Label[3];
    double x=label1.getLayoutX();
    double y=label1.getLayoutY();
    double yy=textField1.getLayoutY();

        for (int i=0;i<this.getnum();i++) {
            labl[i]=new Label();
        y+=20;
        labl[i].setLayoutY(y+20+40+20+10+100+30+10);
        labl[i].setLayoutX(textField1.getLayoutX());
        labels[i] = new Label();
        yy+=19;
        labels[i].setLayoutX(780);
        labels[i].setLayoutY(yy-55+40+20+10+100+40);
        root.getChildren().addAll(labels[i],labl[i]);
    }

        int result=0;
    File file1=null;
    if (xx==1){
        file1=new File("table1.txt");
    }
    else if (xx==2){
        file1=new File("table2.txt");
    }
    else if (xx==3){
        file1=new File("table3.txt");
    }
    else if (xx==4){
        file1=new File("table4.txt");
    }
    else {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.show();
    }


        try {int i=0;
        Scanner scan=new Scanner(file1);
        while (scan.hasNext()){
            String d=scan.next();
            String e=scan.next();
            labels[i].setText(String.valueOf(e));
            result+=Double.valueOf(e);
            labl[i].setText("  "+d);
            i++;
        }
        Scanner scanner=new Scanner(new File("WriteUser.txt"));
        String username = null;
        while (scanner.hasNext()){
            username=scanner.next();
        }
            labels1[0]=new Label();
        labels1[0].setLayoutY(600+10);
        labels1[0].setLayoutX(800+70);
        labels1[0].setText(String.valueOf(result));
            labels1[1]=new Label();
            labels1[1].setText(String.valueOf(result));
            labels1[1].setLayoutY(600+10+60+15);
            labels1[1].setLayoutX(800+70);
            Label ID=new Label(getID(username));
            String inv=String.valueOf(BillNum());
            Label invoice=new Label(inv);
            invoice.setFont(new Font(10));
            invoice.setLayoutX(800-70);
            invoice.setLayoutY(50+30+30+10);
            ID.setLayoutY(610+5);
            ID.setLayoutX(50+20+40+20+10+15+15+10+20+5);
        root.getChildren().addAll(labels1[0],labels1[1],ID,invoice);
        File files=new File("Invoice.txt");
        FileWriter fileWriter=new FileWriter(files,true);
        fileWriter.write(inv+" ");
        fileWriter.write(getID(username)+" ");
        fileWriter.write(result+"\n");
        fileWriter.close();


    }catch (    IOException e){
        e.printStackTrace();
    }
        root.getChildren().addAll( label1);
    Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


int getnum()throws IOException{
    File file1=null;
    if (this.xy==1){
        file1=new File("table1.txt");
    }
    else if (this.xy==2){
        file1=new File("table2.txt");
    }
    else if (this.xy==3){
        file1=new File("table3.txt");
    }
    else if (this.xy==4){
        file1=new File("table4.txt");
    }
    else {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.show();
    }

    Scanner scanner= null;
    if (file1 != null) {
        scanner = new Scanner(file1);
    }
    int i=0;
    while (scanner.hasNext()){
          String  v=scanner.next();
          String b=scanner.next();
          i++;
      }
      return i;
}
    String getID(String username) throws IOException{
        Scanner scanner=new Scanner(new File("Waiterslog.txt"));
        while (scanner.hasNext()){
            String a=scanner.next();
            String b=scanner.next();
            String c=scanner.next();
            if (b.compareTo(username)==0){
                return a;
            }
        }
        return null;
    }
     int BillNum()throws IOException{
       File file=new File("BillNumber.txt");

        FileWriter writer=new FileWriter(file,true);
        PrintWriter print=new PrintWriter(writer);
        if (file.length()==0){
        print.print(1);
        print.print("\n");
        BillNumber=1;
        print.close();
        writer.close();
        }
        else {
       Scanner scanner=new Scanner(file);
      while (scanner.hasNextInt()){
          BillNumber=scanner.nextInt()+1;
      }

        print.print(BillNumber);
      print.print("\n");
        print.close();
        writer.close();}
        return BillNumber;
    }
}
