package Coustomer;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public interface WaiterMenu {
    void menu();
    void handleOptions(CheckBox[] boxes, int z);
    int getbox(ChoiceBox<Integer> choiceBox);

}