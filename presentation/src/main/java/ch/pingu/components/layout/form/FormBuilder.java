package ch.pingu.components.layout.form;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FormBuilder {
  private Text title = new Text("Form");
  private final List<Label> labels = new ArrayList<>();
  private final List<TextField> fields = new ArrayList<>();
  private PasswordField passwordField;
  private HBox submitButton;

  public FormBuilder() {
  }

  public FormBuilder title(String value) {
    title = new Text(value);
    return this;
  }

  public FormBuilder field(String value) {
    labels.add(new Label(value));
    fields.add(new TextField());
    return this;
  }

  public FormBuilder passwordField(String value) {
    labels.add(new Label(value));
    passwordField = new PasswordField();
    fields.add(passwordField); // PasswordField extends TextField
    return this;
  }

  public FormBuilder submitButton(String value) {
    // define button container to be able to add it to form
    submitButton = new HBox();

    // define button
    Button button = new Button(value);
    // set event on button to invoke submit
    button.setOnAction(actionEvent -> {
      signupUser();
    });

    // add button to its container -> HBox 
    submitButton.getChildren().add(button);
    return this;
  }

  public GridPane build() {
    GridPane form = new GridPane();

    // skip title -> use count to place submit button at the end of the form -> amount of fields is variable
    int countOfRows = 1;

    if (title != null) {
      form.add(title, 0, 0);
    }

    if (labels.size() > 0) {
      for (int i = 0; i < labels.size(); i++) {
        form.add(labels.get(i), 0, i + 1);
      }
    }

    if (fields.size() > 0) {
      for (int i = 0; i < fields.size(); i++) {
        countOfRows++;
        form.add(fields.get(i), 1, i + 1);
      }
    }

    // check if button is used. else inform developer to set a submit button
    if (submitButton != null) {
      form.add(submitButton, 0, countOfRows);
    } else {
      Text info = new Text("You have to define a submit button.");
      form.add(info, 0, countOfRows);
    }

    return form;
  }

  private void signupUser() {
    // call the user controller
    // user controller orchestrates service -> user service
    // user service creates user object -> model / entity
    // service defines interface which adapter implements
    // adapter fetches data from the service and persists it in DB
  }
}
