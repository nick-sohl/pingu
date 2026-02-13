package ch.pingu;

import ch.pingu.components.layout.Sidebar;
import ch.pingu.views.DashboardView;
import ch.pingu.views.SettingsView;
import ch.pingu.views.TransactionView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
  // To switch between views
  // StackPane lays out its children in a back-to-front stack.
  // 0th child being the bottom and last child on top
  StackPane viewStack = new StackPane();

  // Launch App
  public static void main(String[] args) {
    launch(args);
  }

  // Hirachy: Application (Entry) -> Stage (Window) -> Scene (container for all content)
  // -> Node (base class for all UI elements) -> Parent (Node that can have children)
  // -> Region -> Control (UI controls: Button)
  // or Pane (layout containers: BorderPane, HBox, VBox etc.)
  @Override
  public void start(Stage stage) {
    // Views
    DashboardView dashboardView = new DashboardView();
    TransactionView transactionView = new TransactionView();
    SettingsView settingsView = new SettingsView();

    // Initially set Dashboard View on Stack
    viewStack.getChildren().add(dashboardView);

    // Components
    Sidebar sidebar = new Sidebar(); // VBox

    // Controls
    // Define Buttons for Sidebar Navigation
    Button dashboardButton = new Button("Dashboard");
    Button transactionsButton = new Button("Transactions");
    Button settingsButton = new Button("Settings");
    // Collect Buttons into Array
    Button[] buttons = {dashboardButton, transactionsButton, settingsButton};

    // Provide Sidebar with Buttons
    sidebar.addButtons(buttons);
    
    // Set Events on Buttons to set different Views on Stack
    dashboardButton.setOnAction(actionEvent -> {
      showView(dashboardView);
    });
    transactionsButton.setOnAction(actionEvent -> {
      showView(transactionView);
    });
    settingsButton.setOnAction(actionEvent -> {
      showView(settingsView);
    });


    // Create a Region to place components in it's "regions"
    HBox container = new HBox();

    // Place components inside Region
    container.getChildren().addAll(sidebar, viewStack);

    // Scene => Container for all content -> Set dimensions and Region
    Scene scene = new Scene(container, 1920, 1100);

    // Stage => Window -> Define Title of Window and provide scene
    stage.setTitle("Pingu Currency Exchange System");
    stage.setScene(scene);

    stage.show();
  }

  public void showView(Node view) {
    viewStack.getChildren().setAll(view);
  }

}
