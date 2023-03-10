package edu.ntnu.idatt2001.lectures.property.ex4;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PropertyExampleApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {

    Box box = new Box();

    // Setting the properties of the Box
    box.setWidth(150.0);
    box.setHeight(150.0);
    box.setDepth(100.0);

    // Setting the position of the box
    box.setTranslateX(50);
    box.setTranslateY(50);
    box.setTranslateZ(50);

    // Setting the material of the box
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseColor(Color.DARKSLATEBLUE);
    box.setMaterial(material);

    // Setting the rotation animation to the box
    RotateTransition rotateTransition = new RotateTransition();
    rotateTransition.setDuration(Duration.millis(1000));
    rotateTransition.setNode(box);
    rotateTransition.setAxis(Rotate.Y_AXIS);
    rotateTransition.setByAngle(360);
    rotateTransition.setCycleCount(50);
    rotateTransition.setAutoReverse(false);

    rotateTransition.play();

    GridPane pane = new GridPane();
    pane.add(box, 0, 0);

    ReadOnlyDoubleProperty widthProperty = pane.widthProperty();
    ReadOnlyDoubleProperty hightProperty = pane.heightProperty();

    widthProperty.addListener((ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) -> {
      Double delta = newVal.doubleValue() - oldVal.doubleValue();
      double newWidth = delta == newVal.doubleValue() ? 0: delta;
      box.setWidth(box.getWidth() + newWidth);
    });

    hightProperty.addListener((ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) -> {
      Double delta = newVal.doubleValue() - oldVal.doubleValue();
      double newHeight = delta == newVal.doubleValue() ? 0: delta;
      box.setHeight(box.getHeight() + newHeight);
    });

    Scene scene = new Scene(pane, 300, 300, true);
    primaryStage.setScene(scene);
    primaryStage.setTitle("2D Example");

    primaryStage.show();
  }
}