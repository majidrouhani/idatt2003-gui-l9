//VM argument: --module-path "C:\JavaFX\javafx-sdk-17.0.2\lib" --add-modules=javafx.controls

package edu.ntnu.idatt2001.lectures.observable.ex2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObservableListApp extends Application {

  private ObservableList<String> countries;
  private ObservableList<String> capitals;

  private ListView<String> countriesListView;
  private ListView<String> capitalsListView;

  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Arrange Countries and Capitals");
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 500, 450);

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
    ColumnConstraints column2 = new ColumnConstraints(50);
    ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
    column1.setHgrow(Priority.ALWAYS);
    column3.setHgrow(Priority.ALWAYS);
    gridPane.getColumnConstraints().addAll(column1, column2, column3);

    Label countriesLabel = new Label("Countries");
    GridPane.setHalignment(countriesLabel, HPos.CENTER);
    gridPane.add(countriesLabel, 0, 0);

    Label capitalsLabel = new Label("Capitals");
    GridPane.setHalignment(capitalsLabel, HPos.CENTER);
    gridPane.add(capitalsLabel, 2, 0);

    gridPane.add(countriesListView, 0, 1);
    gridPane.add(capitalsListView, 2, 1);

    VBox vbox = new VBox();
    Button leftButton = new Button(" < ");
    leftButton.setOnAction( (ActionEvent event) -> {
      String str = capitalsListView.getSelectionModel().getSelectedItem();
      if (str != null) {
        capitals.remove(str);
        countries.add(str);
      }
    });

    Button rightButton = new Button(" > ");
    rightButton.setOnAction((ActionEvent event) -> {
      String str = countriesListView.getSelectionModel().getSelectedItem();
      if (str != null) {
        countriesListView.getSelectionModel().clearSelection();
        countries.remove(str);
        capitals.add(str);
      }
    });

    vbox.getChildren().addAll(rightButton, leftButton);

    gridPane.add(vbox, 1, 1);

    root.setCenter(gridPane);
    GridPane.setVgrow(root, Priority.ALWAYS);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void init() throws Exception {
    super.init();

    countries = FXCollections.observableArrayList("Australia", "Vienna", "Canberra", "Austria", "Belgium", "Santiago",
        "Chile", "Brussels", "San Jose", "Finland", "India");
    countriesListView = new ListView<>(countries);

    capitals = FXCollections.observableArrayList("Costa Rica", "Norway", "Oslo","New Delhi", "Washington DC", "USA", "UK", "London",
        "Helsinki", "Taiwan", "Taipei", "Sweden", "Stockholm");
    capitalsListView = new ListView<>(capitals);

  }  
}