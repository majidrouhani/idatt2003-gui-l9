/* Online help: https://code.makery.ch/blog/javafx-dialogs-official/
 */

package edu.ntnu.idatt2001.lectures.dialog.modality.ex2;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogInformationMultipleApplicationModality extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("My first stage with scene");
    Button btn = new Button();
    btn.setText("Open new window");

    
    EventHandler<ActionEvent> eventHandler = new EventHandler<>() {
      @Override
      public void handle(ActionEvent event) {
        
        Label secondLabel = new Label("I'm a Label on new Window");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);
        
        Button btn = new Button();
        btn.setText("Say 'Hello World' in the new windows");
        
        btn.setOnMouseClicked((MouseEvent e) -> {          
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.initModality(Modality.APPLICATION_MODAL);
          alert.setTitle("Information Dialog");
          alert.setHeaderText("Look, an Information Dialog");
          alert.setContentText("I have a great message for you!");
          alert.showAndWait();          
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        

        newWindow.setScene(new Scene(root, 300, 250));
        
        newWindow.show();
        
      }
    };
    
    btn.setOnAction(eventHandler);

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}