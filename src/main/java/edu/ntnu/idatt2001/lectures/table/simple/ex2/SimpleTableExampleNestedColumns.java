//http://www.java2s.com/Tutorials/Java/JavaFX/0650__JavaFX_TableView.htm

package edu.ntnu.idatt2001.lectures.table.simple.ex2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleTableExampleNestedColumns extends Application {

  TableView<Contact> tableView = new TableView<Contact>();

  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {

    createTable();

    fillTable();

    tableView.setOnMouseClicked(mouseEvent -> {
      Contact selectedPerson = tableView.getSelectionModel().getSelectedItem();
      if (selectedPerson != null) {
        System.out.println(selectedPerson.getSecondaryEmail());
      }
    });

    BorderPane root = new BorderPane();

    root.setCenter(tableView);

    Scene scene = new Scene(root, 460, 250);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private void createTable() {

    TableColumn<Contact, String> col1 = new TableColumn<>("First Name");
    col1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

    TableColumn<Contact, String> col2 = new TableColumn<>("Last Name");
    col2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    TableColumn<Contact, String> col3 = new TableColumn<>("Email");

    TableColumn<Contact, String> col31 = new TableColumn<>("Primary");
    col31.setCellValueFactory(new PropertyValueFactory<>("primaryEmail"));

    TableColumn<Contact, String> col32 = new TableColumn<>("Secondary");
    col32.setCellValueFactory(new PropertyValueFactory<>("secondaryEmail"));
    
    col3.getColumns().addAll(col31, col32);
        
    tableView.getColumns().add(col1);
    tableView.getColumns().add(col2);
    tableView.getColumns().add(col3);

  }

  private void fillTable() {
    tableView.getItems().add(new Contact("John", "Doe", "john.doe@hotmail.com","john.doe@gmail.com"));
    
    tableView.getItems().add(new Contact("Jane", "Deer", "jane.deere@hotmail.com","jane.deere@gmail.com"));
    tableView.getItems().add(new Contact("Han", "Hansen", "hans.hansen@hotmail.com", "hans.hansen@gmail.com"));
  }
}