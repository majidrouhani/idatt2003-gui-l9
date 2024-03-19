package edu.ntnu.idatt2003.lectures.table.simple.ex1;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleTableEditApp extends Application {

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

    tableView.setOnMouseClicked(e -> handleMouseEvent(e));

    primaryStage.show();
  }

  private void handleMouseEvent(MouseEvent e) {
      SimpleContact selectedPerson = tableView.getSelectionModel().getSelectedItem();
      if (selectedPerson != null) {
        System.out.println(selectedPerson.getFirstName());
      }
  } 

  private void createTable() {

    TableColumn<SimpleContact, String> col1 = new TableColumn<>();
    col1.setText("First Name");
    col1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col1.setOnEditCommit(event -> {
            SimpleContact person = event.getRowValue();
            person.firstNameProperty().setValue(event.getNewValue());
        });


    TableColumn<SimpleContact, String> col2 = new TableColumn<>();
    col2.setText("Last Name");
    col2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    TableColumn<SimpleContact, String> col3 = new TableColumn<>();
    col3.setText("Email");
    col3.setCellValueFactory(new PropertyValueFactory<>("email"));

    List<TableColumn<SimpleContact, ?>> columns = List.of(col1, col2, col3);
    tableView.getColumns().addAll(columns);    

    tableView.setEditable(true);
  }

  private void fillTable() {
    List<SimpleContact> contacts = List.of(
      new SimpleContact("John", "Doe", "john.doe@gmail"),
      new SimpleContact("Jane", "Deer", "jane.deer@gmail"),
      new SimpleContact("Hans", "Hansen", "hans.hansen@gmail"),
      new SimpleContact("Ola", "Nordmann", "ola.nordmann@gmail"),
      new SimpleContact("Sara", "Svensson", "sara.svensson@gmail"),
      new SimpleContact("Hanna", "Hansson", "hanna.hansson@gmail")
    );
    
    tableView.getItems().addAll(contacts);
  }
}