package edu.ntnu.idatt2001.lectures.table.simple.ex4;

import edu.ntnu.idatt2001.lectures.table.simple.ex1.SimpleContact;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddDialog {

  public void show(Stage primaryStage, ContactRegister contactRegister, ObservableList<SimpleContact> contacts) {

    GridPane grid = new GridPane();

    Label firstnameLabel = new Label("Firstname: ");
    TextField firstname = new TextField ();
    grid.add(firstnameLabel,0,0);
    grid.add(firstname,1,0);

    Label lastnameLabel = new Label("Lastname: ");
    TextField lastname = new TextField();
    grid.add(lastnameLabel,0,1);
    grid.add(lastname,1,1);

    Label emailLabel = new Label("Email: ");
    TextField email = new TextField();
    grid.add(emailLabel,0,2);
    grid.add(email,1,2);

    Button ok = new Button("OK");

    EventHandler<ActionEvent> eventAddContact = (ActionEvent e) -> {

            contactRegister.addContact(new SimpleContact(firstname.getText(), lastname.getText(), email.getText()));
            
            contacts.setAll(contactRegister.getAllContacts());
            Node source = (Node) e.getSource();
            Stage stage = (Stage)source.getScene().getWindow();
            stage.close();     
    };

    ok.setOnAction(eventAddContact);
  
    grid.add(ok, 1, 3);

    Scene dialogScene = new Scene(grid, 230, 100);

    // New window (Stage)
    Stage newWindow = new Stage();
    newWindow.setTitle("Add contact");
    newWindow.setScene(dialogScene);

    // Set position of second window, related to primary window.
    newWindow.setX(primaryStage.getX() + 200);
    newWindow.setY(primaryStage.getY() + 100);
    
    Button btn = new Button();
    btn.setText("Say 'Hello World' in the new windows");

    newWindow.show();
  }            
}
