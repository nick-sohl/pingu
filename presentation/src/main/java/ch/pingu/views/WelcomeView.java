package ch.pingu.views;

import ch.pingu.components.layout.welcome.Footer;
import ch.pingu.components.layout.welcome.Navbar;
import ch.pingu.views.welcome.LoginView;
import ch.pingu.views.welcome.RegistrationView;
import ch.pingu.views.welcome.StartView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WelcomeView extends VBox {
  // Components
  Navbar navbar;
  StackPane viewStack;
  Footer footer;

  //Views
  StartView startView;
  RegistrationView registrationView;
  LoginView loginView;

  // Controls
  Button signupButton;
  Button loginButton;

  public WelcomeView() {
    // CSS file
    this.getStylesheets().add(getClass().getResource("/styles/base.css").toExternalForm());
    // CSS Selector
    this.getStyleClass().add("welcome-view");

    // Controls
    this.signupButton = createButton("Sign up");
    this.loginButton = createButton("Login");
    // INFO: We add buttons here to add events to them to switch views
    Button[] buttons = {signupButton, loginButton};

    // Components
    this.navbar = new Navbar(buttons);
    this.viewStack = new StackPane();
    this.footer = new Footer();

    // Views
    this.startView = new StartView();
    this.registrationView = new RegistrationView();
    this.loginView = new LoginView();

    // Stack of Views
    viewStack.getChildren().addAll(startView, registrationView, loginView);

    signupButton.setOnAction(actionEvent -> {
      showView(registrationView);
    });
    loginButton.setOnAction(actionEvent -> {
      showView(loginView);
    });

    this.getChildren().addAll(navbar, viewStack, footer);

    showView(startView);
  }

  public void showView(Node view) {
    viewStack.getChildren().setAll(view);
  }

  private Button createButton(String value) {
    Button btn = new Button(value);
    return btn;
  }
}
