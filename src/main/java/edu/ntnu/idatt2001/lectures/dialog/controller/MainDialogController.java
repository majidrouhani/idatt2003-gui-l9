package edu.ntnu.idatt2001.lectures.dialog.controller;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MainDialogController {
  private MainDialogController() {
    throw new IllegalStateException("MainController");
  }

  public static void exit(ActionEvent event) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setContentText("Do you want to close the application?");

    Optional<ButtonType> result = alert.showAndWait();

    
    if (result.isPresent() && result.get() == ButtonType.OK) {
      Platform.exit();
    }
  }

  public static void about(ActionEvent event) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("I have a great message for you!");
    alert.showAndWait();
  }  
}
