package ch.pingu.views.application;

import ch.pingu.components.layout.ViewHeading;
import javafx.scene.layout.VBox;

public abstract class BaseView extends VBox {
    ViewHeading viewHeading;

    public BaseView(String value) {
        viewHeading = new ViewHeading(value);

        this.getChildren().addAll(viewHeading);

        // add style class for external CSS selector
        this.getStyleClass().add("base-view");
    }
}
