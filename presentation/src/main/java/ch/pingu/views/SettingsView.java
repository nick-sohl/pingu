package ch.pingu.views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SettingsView extends VBox {
    public SettingsView() {
        this.setStyle("-fx-background-color: #F3F3F3;");
        this.setPadding(new Insets(48));
        this.setSpacing(16);
        // Add children
        this.getChildren().add(
          createText("Hello from the Settings View!")
        );
    }

    private Text createText(String value) {
      Text text = new Text(value);
      // TODO: Styling
      return text;
    }
}
