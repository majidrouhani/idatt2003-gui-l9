package edu.ntnu.idatt2003.lectures.property;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PropertyExamplePaneApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {

    Pane pane = new Pane();

    ReadOnlyDoubleProperty widthProperty = pane.widthProperty();
    ReadOnlyDoubleProperty hightProperty = pane.heightProperty();

    widthProperty.addListener((ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) -> 
      System.out.println("widthProperty changed from " + oldVal.intValue() + " to " + newVal.intValue())
    );

    hightProperty.addListener((ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) -> 
      System.out.println("hightProperty changed from " + oldVal.intValue() + " to " + newVal.intValue())
    );

    Scene scene = new Scene(pane, 200, 200, true);
    primaryStage.setScene(scene);
    primaryStage.setTitle("2D Example");

    primaryStage.show();
  }
}