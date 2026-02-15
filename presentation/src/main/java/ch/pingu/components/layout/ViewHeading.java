package ch.pingu.components.layout;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewHeading extends VBox {

  public ViewHeading(String text) {
    this.getStyleClass().add("view-heading");

    Text heading = new Text(text);

    this.getChildren().add(heading);
  }
}
