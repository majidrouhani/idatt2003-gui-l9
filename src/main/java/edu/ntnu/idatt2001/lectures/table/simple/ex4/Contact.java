package edu.ntnu.idatt2001.lectures.table.simple.ex4;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

  private SimpleStringProperty firstName = new SimpleStringProperty();
  private SimpleStringProperty lastName = new SimpleStringProperty();;
  private SimpleStringProperty email = new SimpleStringProperty();;

  public Contact() {
  }

  public Contact(String firstName, String lastName, String email) {
    this.firstName.setValue(firstName);
    this.lastName.setValue(lastName);
    this.email.setValue(email);
  }

  public String getFirstName() {
    return this.firstName.getValue();
  }

  public void setFirstName(String firstName) {
    this.firstName.setValue(firstName);
  }

  public String getLastName() {
    return lastName.getValue();
  }

  public void setLastName(String lastName) {
    this.lastName.setValue(lastName);
  }

  public String getEmail() {
    return email.getValue();
  }

  public void setEmail(String email) {
    this.email.setValue(email);
  }
}