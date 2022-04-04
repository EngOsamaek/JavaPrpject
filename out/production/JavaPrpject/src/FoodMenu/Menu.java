package FoodMenu;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mkyong.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

abstract class Menu extends MenuDesign {
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String>des=new ArrayList<>();
    ArrayList<Double>pri=new ArrayList<>();
    String na,su,ad,em;
    Table w=new Table();
    Label idnum = new Label("enter the number of the item");
    TextField textField = new TextField();
    Button button = new Button("search");
    Label namemeal = new Label("Name of the meal");
    TextField nametxt = new TextField();
    Label description = new Label("Description of the meal");
    TextField desctxt = new TextField();
    Label Price = new Label("Price");
    TextField pricetxt = new TextField();
    Label calories = new Label("Calories");
    TextField caloriestxt = new TextField();
    Button back = new Button("Return");
    Button edit = new Button("Update");
    abstract void setTex(String x)throws IOException;
    ArrayList<Integer>cal=new ArrayList<>();
    LinkedHashMap<Integer,Object> linkedHash=new LinkedHashMap<>();
    abstract void SetMenu();

}
