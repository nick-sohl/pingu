package ch.pingu;

import ch.pingu.views.ApplicationView;
import ch.pingu.views.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  boolean authenticated = true;

  // Views
  WelcomeView welcomeView = new WelcomeView();
  ApplicationView applicationView = new ApplicationView();

  // Scenes
  Scene welcomeScene = new Scene(welcomeView, 1920, 1100);
  Scene applicationScene = new Scene(applicationView, 1920, 1100);

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
    if (!authenticated) {
      stage.setTitle("Welcome to Pingu");
      stage.setScene(welcomeScene);
    } else {
      // Stage => Window -> Define Title of Window and provide scene
      stage.setTitle("Pingu Currency Exchange System");
      stage.setScene(applicationScene);
    }

    stage.show();
  }
}
