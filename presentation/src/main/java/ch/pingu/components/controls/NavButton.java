package ch.pingu.components.controls;

import javafx.scene.control.Button;

public class NavButton extends Button {

  public NavButton(String value) {
    super(value);

    this.getStyleClass().add("nav-button");
  }
}
