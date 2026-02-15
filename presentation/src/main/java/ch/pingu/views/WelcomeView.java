package ch.pingu.views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WelcomeView extends VBox {

  public WelcomeView() {
    HBox buttonContainer = new HBox();

    Text headline = createHeadline("Welcome to Pingu!");
    Button signup = createButton("Sign up");
    Button login = createButton("Login");

    // assemble
    buttonContainer.getChildren().addAll(signup, login);
    this.getChildren().addAll(headline, buttonContainer);
  }

  private Text createHeadline(String value) {
    // create
    Text text = new Text(value);

    // style
    text.setStyle("-fx-font-family: Helvetica; -fx-font-weight: bold; -fx-font-size: 48;");

    return text;
  }

  private Button createButton(String value) {
    // create
    Button btn = new Button(value);

    // style
    btn.setStyle(
      "-fx-background-color: #F3F3F3; -fx-padding: 16 8;"
    );

    return btn;
  }
}
