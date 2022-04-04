package mkyong;
//import FoodMenu.MenuDesign;

import FoodMenu.MenuDesign;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
public class ManagerSignin implements CheckUp {
    private String user= "1",password="1";
    int Ref;
    int SetRef(){
        Random randomNum=new Random();
        return this.Ref = randomNum.nextInt(10000-1000)+1000;
    }


    @Override
    public boolean checkUserName(String key,String value) throws NullPointerException {
        if(key.compareTo(this.user)==0 && value.compareTo(this.password)==0){
        ManagerSignin managerSignin=new ManagerSignin();
        return true;
        }
        else {
            System.out.println("error");
        }
        return false;
    }
    @Override
    public void checkInfo() {
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
        TextField nametext =new TextField();
        TextField passtext =new PasswordField();
        ImageView view = new ImageView("mkyong/manager1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        name.setLayoutX(293-100-15);
        name.setLayoutY(176);
        nametext.setLayoutX(403-100-50);
        nametext.setLayoutY(176);
        pass.setLayoutX(288-100-15);
        pass.setLayoutY(234);
        pass.setFont(new Font(15));
        name.setFont(new Font(15));
        passtext.setLayoutX(403-100-50);
        passtext.setLayoutY(234);
        Button button = new Button("Enter");
        Button back=new Button("return");
        back.setLayoutX(934);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e)->{
            Main main=new Main();
            main.start(stage);
            stage.close();
        });
        nametext.setPromptText("UserName");
        passtext.setPromptText("Password");
        root.getChildren().addAll(view, nametext,name, passtext,pass,button,back);

        button.setOnAction((ActionEvent e) ->{
            if(managerSignin.checkUserName(nametext.getText(), passtext.getText())) {
                try {
                    managerSignin.sec();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                stage.close();
            }
               else {
                   alert.setContentText("The Username or the password aren't correct");
                   alert.show();
            }
        });
        button.setLayoutX(590-100-50);
        button.setLayoutY(233);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void sec() throws FileNotFoundException {
        RegisterWaiter registerWaiter=new RegisterWaiter();
        Stage stage = new Stage();

            stage.setTitle("Manager main");
            stage.setWidth(1024);
            stage.setHeight(760);
        ImageView view = new ImageView("mkyong/manager1.png");
        view.setFitWidth(1024);
        view.setFitHeight(760);
        AnchorPane root = new AnchorPane();
        FileInputStream fileInputStream8=new FileInputStream("src/mkyong/profile.png");
        Image mg=new Image(fileInputStream8);
        ImageView view11=new ImageView(mg);
        Button Edit=new Button("Waiters Account",view11);
        view11.setFitWidth(75);
        view11.setFitHeight(75);
        Edit.setLayoutX(250);
        Edit.setLayoutY(150+50+50+50);

        Edit.setOnAction((ActionEvent e)-> {
        RegisterUsernameWaiters registerUsernameWaiters=new RegisterUsernameWaiters();
            try {
                registerUsernameWaiters.register();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            stage.close();
        });
            FileInputStream fileInputStream5=new FileInputStream("src/mkyong/seo-and-web.png");
            Image image7=new Image(fileInputStream5);
            ImageView view7=new ImageView(image7);
            view7.setFitHeight(70);
            view7.setFitWidth(70);
            Button addWaiters=new Button("Register waiters",view7);
            addWaiters.setLayoutX(250);
            addWaiters.setLayoutY(150);
            addWaiters.setOnAction((ActionEvent e)->{
                registerWaiter.setData();
                stage.close();
            });



        FileInputStream fileInputStream=new FileInputStream("src/mkyong/business.png");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        Button editWaitersInfo=new Button("Update Waiters info",imageView);
        editWaitersInfo.setLayoutX(50);
        editWaitersInfo.setLayoutY(150);
        editWaitersInfo.setOnAction((ActionEvent e)->{
           Table table=new Table();
            try {
                table.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button back=new Button("return");
        back.setLayoutX(934);
        back.setLayoutY(17);
        back.setOnAction((ActionEvent e)->{
            Main main=new Main();
            main.start(stage);
            stage.close();
        });
        FileInputStream fileInputStream1=new FileInputStream("src/mkyong/files-and-folders (1).png");
        Image men=new Image(fileInputStream1);
        ImageView man=new ImageView(men);
        Button menu=new Button("Menu",man);
        man.setFitWidth(70);
        man.setFitHeight(70);
        menu.setLayoutX(50);
        menu.setLayoutY(300);
        menu.setOnAction((ActionEvent e)-> {
            MenuDesign menuDesign = new MenuDesign();
            menuDesign.mainPage(1);
            stage.close();
        });
        FileInputStream fileInputStream2 =new FileInputStream("src/mkyong/Invoice.png");
        Image image1=new Image(fileInputStream2);
        ImageView imageView1=new ImageView(image1);
        Button invoices=new Button("Invoice",imageView1);
        invoices.setLayoutX(50);
        invoices.setLayoutY(400);
        imageView1.setFitWidth(70);
        imageView1.setFitHeight(70);
        invoices.setOnAction((ActionEvent e)->{
          Invoice invoice=new Invoice();
            try {
                invoice.invoice();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        root.getChildren().addAll(view, back,addWaiters,Edit,editWaitersInfo,menu,invoices);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
  }

}
