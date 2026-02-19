package ch.pingu.components.layout.application;

import javafx.scene.layout.StackPane;

// TODO: Check if we should use this as its own class instead directly in ApplicationView
public class ViewStack extends StackPane {

    public ViewStack() {
        this.getStyleClass().add("view-stack");
    }
}
