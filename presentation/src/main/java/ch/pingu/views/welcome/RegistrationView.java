package ch.pingu.views.welcome;

import ch.pingu.components.layout.form.FormBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RegistrationView extends VBox {

  public RegistrationView() {
    // Build the form
    GridPane form = new FormBuilder()
      .title("Sign up")
      .field("First Name")
      .field("Last Name")
      .passwordField("Password")
      .submitButton("Sign Up")
      .build();

    this.getChildren().add(form);
    this.getStyleClass().add("registration-view");
    form.getStyleClass().add("signup-form");
  }
}
