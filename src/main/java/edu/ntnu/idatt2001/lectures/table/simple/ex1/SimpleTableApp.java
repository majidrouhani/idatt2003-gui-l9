package edu.ntnu.idatt2001.lectures.table.simple.ex1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleTableApp extends Application {

  TableView<SimpleContact> tableView = new TableView<>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    createTable();

    fillTable();

    BorderPane root = new BorderPane();

    root.setCenter(tableView);

    Scene scene = new Scene(root, 310, 250);
    primaryStage.setScene(scene);

    tableView.setOnMouseClicked(mouseEvent -> {
      SimpleContact selectedPerson = tableView.getSelectionModel().getSelectedItem();
      if (selectedPerson != null) {
        System.out.println(selectedPerson.getLastName());
      }
    });

    primaryStage.show();
  }

  private void createTable() {

    tableView.setEditable(true);

    TableColumn<SimpleContact, String> col1 = new TableColumn<>("Firstname");
    col1.setCellValueFactory(new PropertyValueFactory<>("Firstname"));

    TableColumn<SimpleContact, String> col2 = new TableColumn<>("Lastname");
    col2.setCellValueFactory(new PropertyValueFactory<>("lastname"));

    TableColumn<SimpleContact, String> col3 = new TableColumn<>("Email");
    col3.setCellValueFactory(new PropertyValueFactory<>("email"));

    tableView.getColumns().add(col1);
    tableView.getColumns().add(col2);
    tableView.getColumns().add(col3);


  }

  private void fillTable() {
    tableView.getItems().add(new SimpleContact("John", "Doe", "john.doe@hotmail.com"));
    tableView.getItems().add(new SimpleContact("Jane", "Deer", "jane.deere@hotmail.com"));
    tableView.getItems().add(new SimpleContact("Han", "Hansen", "hans.hansen@hotmail.com"));
  }
}