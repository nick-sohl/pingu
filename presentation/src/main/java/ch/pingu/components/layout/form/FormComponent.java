package ch.pingu.components.layout.form;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FormComponent {
  private Text title = new Text("Form");
  private final List<Label> labels = new ArrayList<>();
  private final List<TextField> fields = new ArrayList<>();
  private PasswordField passwordField;

  public FormComponent() {
  }

  public FormComponent title(String value) {
    title = new Text(value);
    return this;
  }

  public FormComponent field(String value) {
    labels.add(new Label(value));
    fields.add(new TextField());
    return this;
  }

  public FormComponent passwordField(String value) {
    labels.add(new Label(value));
    passwordField = new PasswordField();
    fields.add(passwordField); // PasswordField extends TextField
    return this;
  }

  public TextField getField(int index) {
      return fields.get(index);
  }

  public GridPane build() {
    GridPane form = new GridPane();

    form.add(title, 0, 0);

    for (int i = 0; i < labels.size(); i++) {
      form.add(labels.get(i), 0, i + 1);
    }

    for (int i = 0; i < fields.size(); i++) {
      form.add(fields.get(i), 1, i + 1);
    }

    return form;
  }
}
