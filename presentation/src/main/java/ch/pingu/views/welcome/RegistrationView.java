package ch.pingu.views.welcome;

import ch.pingu.components.layout.form.FormComponent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RegistrationView extends VBox {

  public RegistrationView() {
    // Building a Form
    GridPane form = new FormComponent()
      .title("Sign up")
      .field("First Name")
      .field("Last Name")
      .passwordField("Password")
      .build();

    this.getChildren().add(form);
    this.getStyleClass().add("registration-view");
    form.getStyleClass().add("signup-form");
  }
}
