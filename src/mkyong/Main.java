package mkyong;
import Coustomer.WaiterLog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage pstage) {
        Stage stage=new Stage();
        stage.setTitle("O² Restaurant");
        stage.setWidth(1024);
        stage.setHeight(760);
        stage.setResizable(false);
        AnchorPane root=new AnchorPane();
        ManagerSignin a=new ManagerSignin();
        try {
            ImageView view = new ImageView("https://www.ahstatic.com/photos/9231_rsr001_00_p_1024x768.jpg");
            root.getChildren().addAll(view);
           }catch (Exception e) {
            e.printStackTrace(); }
         Button button=new Button("Manager");
         Image image=new Image("mkyong/admin-icon.png");
         ImageView imageView=new ImageView(image);
         imageView.setFitHeight(50);
         imageView.setFitWidth(50);
         imageView.prefHeight(50);
         imageView.prefWidth(50);
         button.setGraphic(imageView);
         button.setOnAction((e)->{a.checkInfo();
         stage.close();
         });
        Button button1=new Button("Waiter");
        Image image1=new Image("mkyong/waiter-icon-png-26.png");
        ImageView view=new ImageView(image1);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.prefHeight(50);
        view.prefWidth(50);
        button1.setGraphic(view);
        button1.setLayoutX(650);
        button1.setLayoutY(195+100);
        button1.setOnAction((ActionEvent e)->{
            WaiterLog waiterLog=new WaiterLog();
            waiterLog.WaiterLogin();
            stage.close();
        });
        button.setLayoutX(200);
        button.setLayoutY(195+100);

        root.getChildren().addAll(button,button1);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){ launch(args); }
}