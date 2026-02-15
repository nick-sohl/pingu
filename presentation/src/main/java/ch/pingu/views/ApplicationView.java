package ch.pingu.views;

import ch.pingu.components.controls.NavButton;
import ch.pingu.components.layout.application.Sidebar;
import ch.pingu.views.application.DashboardView;
import ch.pingu.views.application.SettingsView;
import ch.pingu.views.application.TransactionView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class ApplicationView extends HBox {
    // Layouts
    Sidebar sidebar = new Sidebar(); // VBox
    StackPane views = new StackPane();

    // Views
    DashboardView dashboardView = new DashboardView();
    TransactionView transactionView = new TransactionView();
    SettingsView settingsView = new SettingsView();

    // Controls for sidebar navigation
    Button dashboardButton = new NavButton("Dashboard");
    Button transactionsButton = new NavButton("Transactions");
    Button settingsButton = new NavButton("Settings");

    public ApplicationView() {

      HBox.setHgrow(views, Priority.ALWAYS);
      // Initially set Dashboard View on Stack
      views.getChildren().add(dashboardView);

      // Collect Buttons into Array
      Button[] buttons = {dashboardButton, transactionsButton, settingsButton};

      dashboardButton.getStyleClass().add("active-nav-button");

      // Provide Sidebar with Buttons
      sidebar.addButtons(buttons);
      
      // Set Events on Buttons to navigate through stack of views
      dashboardButton.setOnAction(actionEvent -> {
        showView(dashboardView);
      });
      transactionsButton.setOnAction(actionEvent -> {
        showView(transactionView);
      });
      settingsButton.setOnAction(actionEvent -> {
        showView(settingsView);
      });

      // Place components inside Region
      this.getChildren().addAll(sidebar, views);

      // Get stylesheet from the classpath
      // INFO: Maven copies everything from src/main/resources/ onto the classpath at build time.
      this.getStylesheets().add(getClass().getResource("/styles/base.css").toExternalForm());


    }

  public void showView(Node view) {
    views.getChildren().setAll(view);
    activeButton();
  }

  private void activeButton() {
      dashboardButton.getStyleClass().remove("active-nav-button");
      transactionsButton.getStyleClass().remove("active-nav-button");
      settingsButton.getStyleClass().remove("active-nav-button");

      Node top = views.getChildren().getLast();

      switch (top) {
        case DashboardView dv -> dashboardButton.getStyleClass().add("active-nav-button");
        case TransactionView tv -> transactionsButton.getStyleClass().add("active-nav-button");
        case SettingsView sv -> settingsButton.getStyleClass().add("active-nav-button");
        default -> {}
      }
  }

}
