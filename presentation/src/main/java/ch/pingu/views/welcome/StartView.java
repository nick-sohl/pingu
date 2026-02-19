package ch.pingu.views.welcome;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartView extends VBox {
  Text headline;

  public StartView() {
    this.headline = createHeadline("Welcome to Pingu!");
    this.getStyleClass().add("start-view");
    headline.getStyleClass().add("headline");

    // Add components to view
    this.getChildren().addAll(headline);

  }

  private Text createHeadline(String value) {
    Text text = new Text(value);
    // INFO: I have created utility classes in the css file and using them here.
    // TODO: Decide what to use and when to use.
    return text;
  }

}
