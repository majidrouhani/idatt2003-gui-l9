//http://www.java2s.com/Tutorials/Java/JavaFX/0650__JavaFX_TableView.htm

package edu.ntnu.idatt2003.lectures.table.simple.ex2;

import java.util.List;

import edu.ntnu.idatt2003.lectures.table.simple.ex1.SimpleContact;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleTableNestedColumnsApp extends Application {

  TableView<Contact> tableView = new TableView<>();

  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {

    createTable();

    fillTable();

    tableView.setOnMouseClicked(e -> handleMouseEvent(e));

    BorderPane root = new BorderPane();

    root.setCenter(tableView);

    Scene scene = new Scene(root, 460, 250);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private void handleMouseEvent(MouseEvent e) {
      SimpleContact selectedPerson = tableView.getSelectionModel().getSelectedItem();
      if (selectedPerson != null) {
        System.out.println(selectedPerson.getLastName());
      }
  } 

  private void createTable() {

    TableColumn<Contact, String> col1 = new TableColumn<>("First Name");
    col1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    tableView.getColumns().add(col1);

    TableColumn<Contact, String> col2 = new TableColumn<>("Last Name");
    col2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    tableView.getColumns().add(col2);

    TableColumn<Contact, String> col3 = new TableColumn<>("Email");

    TableColumn<Contact, String> col31 = new TableColumn<>("Primary");
    col31.setCellValueFactory(new PropertyValueFactory<>("email"));

    TableColumn<Contact, String> col32 = new TableColumn<>("Secondary");
    col32.setCellValueFactory(new PropertyValueFactory<>("secondaryEmail"));

    col3.getColumns().add(col31);
    col3.getColumns().add(col32);
    tableView.getColumns().add(col3);
  }

  private void fillTable() {
    List<Contact> contacts = List.of(
      new Contact("John", "Doe", "john.doe@hotmail.com","john.doe@gmail.com"),
      new Contact("Jane", "Deer", "jane.deere@hotmail.com","jane.deere@gmail.com"),
      new Contact("Han", "Hansen", "hans.hansen@gmail.com", "hans.hansen@gmail.com"),
      new Contact("Ola", "Nordmann", "ola.nordmann@gmail.com", "ola.nordmann@gmail.com"),
      new Contact("Sara", "Svensson", "sara.svensson@gmail.com", "sara.svensson@gmail.com")
    );
    tableView.getItems().addAll(contacts);
  }
}