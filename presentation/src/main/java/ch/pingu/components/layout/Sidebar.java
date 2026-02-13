package ch.pingu.components.layout;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sidebar extends VBox {

    public Sidebar() {
        // Configure sidebar
        this.setStyle("-fx-background-color: #2c3e50; -fx-border-color: #000; -fx-border-width: 0 1px 0 0");
        this.setPadding(new Insets(16));
        this.setSpacing(8);
    }
 
    public void addButtons(Button[] buttons) {
        for (Button button : buttons) {
          button.setPrefSize(250, 40);
        }
        // TODO: Style and configure
        this.getChildren().addAll(
          buttons
        );
    }
}
