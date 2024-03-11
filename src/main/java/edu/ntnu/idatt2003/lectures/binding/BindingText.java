/* Online help: https://openjfx.io/openjfx-docs/#maven
 * Non-modular from IDE
 */

package edu.ntnu.idatt2003.lectures.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BindingText extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("My first stage with scene");

    // Create text fields
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    TextField emailDomain = new TextField("Email domain");
    TextArea email = new TextArea();

    // Bind text fields
    email.textProperty().bind(Bindings.concat(firstName.textProperty(),".",lastName.textProperty(),"@",emailDomain.textProperty()));

    // Add text fields to scene
    VBox root = new VBox();
    root.getChildren().addAll(firstName);
    root.getChildren().addAll(lastName);
    root.getChildren().addAll(emailDomain);
    root.getChildren().addAll(email);

    primaryStage.setScene(new Scene(root, 400, 250));
    primaryStage.show();
  }

}