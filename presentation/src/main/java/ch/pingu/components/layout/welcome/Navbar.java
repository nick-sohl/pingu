package ch.pingu.components.layout.welcome;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class Navbar extends HBox {
  Text appName;
  HBox buttonContainer;
  Region spacer;

  public Navbar(Button[] buttons) {
    this.getStyleClass().add("navbar");

    this.appName = new Text("Pingu");
    this.buttonContainer = new HBox();
    this.spacer = new Region();

    for (Button button : buttons) {
      buttonContainer.getChildren().addAll(button);
    }

    this.getChildren().addAll(appName, spacer, buttonContainer);

    HBox.setHgrow(spacer, Priority.ALWAYS);

    appName.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-font-family: sans-serif");
    buttonContainer.setStyle("-fx-spacing: 16");
  }
}
