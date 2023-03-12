/* Online help: https://openjfx.io/openjfx-docs/#maven
 * Non-modular from IDE
 */

package edu.ntnu.idatt2001.lectures.table.observable.ex1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ObservableText extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("My first stage with scene");

    TextField text1 = new TextField("First name");
    text1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

    TextField text2 = new TextField("Last name");
    text2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

    TextField text3 = new TextField("domain");
    text3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));


    TextArea textArea = new TextArea();
    textArea.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

    textArea.textProperty().bind(Bindings.concat(text1.textProperty(),".",text2.textProperty(),"@",text3.textProperty()));

    VBox root = new VBox();
    root.getChildren().addAll(text1);
    root.getChildren().addAll(text2);
    root.getChildren().addAll(text3);
    root.getChildren().addAll(textArea);

    primaryStage.setScene(new Scene(root, 400, 250));
    primaryStage.show();
  }

}