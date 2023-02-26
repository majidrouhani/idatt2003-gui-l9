package edu.ntnu.idatt2001.lectures.table.simple.ex4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContactRegisterApp extends Application {
  ContactRegister contactRegister = null;

  TableView<Contact> tableView = new TableView<>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    createTable();

    ObservableList<Contact> contacts = getContacts();
    tableView.setItems(contacts);

    tableView.setOnMouseClicked(mouseEvent -> {
      Contact selectedPerson = tableView.getSelectionModel().getSelectedItem();
      if (selectedPerson != null) {
        System.out.println(selectedPerson.getLastName());
      }
    });


    BorderPane root = new BorderPane();

    root.setCenter(tableView);

    Button btn = new Button();
    btn.setText("Add");
    btn.setOnAction((ActionEvent event) -> {
      new AddDialog().show(primaryStage, contactRegister, contacts);
    });

    root.setBottom(btn);  

    Scene scene = new Scene(root, 310, 250);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private void createTable() {

    TableColumn<Contact, String> column1 = new TableColumn<>("First Name");
    column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

    TableColumn<Contact, String> column2 = new TableColumn<>("Last Name");
    column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    TableColumn<Contact, String> column3 = new TableColumn<>("Email");
    column3.setCellValueFactory(new PropertyValueFactory<>("email"));

    tableView.getColumns().add(column1);
    tableView.getColumns().add(column2);
    tableView.getColumns().add(column3);

  }

  private ObservableList<Contact> getContacts() {
    return FXCollections.observableArrayList(this.contactRegister.getAllContacts());
  }

  @Override
  public void init() throws Exception {
    super.init();

    contactRegister = new ContactRegister();
    contactRegister.addContact(new Contact("John", "Doe", "john.doe@hotmail.com"));
    contactRegister.addContact(new Contact("Jane", "Deer", "jane.deere@hotmail.com"));
    contactRegister.addContact(new Contact("Han", "Hansen", "hans.hansen@hotmail.com"));
    contactRegister.addContact(new Contact("Ola", "Nordmann", "ola.nordmann@hotmail.com"));
  }
}