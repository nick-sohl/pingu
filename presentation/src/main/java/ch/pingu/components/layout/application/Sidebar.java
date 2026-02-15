package ch.pingu.components.layout.application;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sidebar extends VBox {

    public Sidebar() {
        this.getStyleClass().add("sidebar");
    }
 
    public void addButtons(Button[] buttons) {
        this.getChildren().addAll(
          buttons
        );
    }
}
