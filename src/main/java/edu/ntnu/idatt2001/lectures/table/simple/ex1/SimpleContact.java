package edu.ntnu.idatt2001.lectures.table.simple.ex1;

import javafx.beans.property.SimpleStringProperty;

public class SimpleContact {

  private SimpleStringProperty firstName = new SimpleStringProperty();
  private SimpleStringProperty lastName = new SimpleStringProperty();
  private SimpleStringProperty email = new SimpleStringProperty();

  public SimpleContact() {
  }

  public SimpleContact(String firstName, String lastName, String email) {
    this.firstName.set(firstName);
    this.lastName.set(lastName);
    this.email.set(email);
  }

  public String getFirstName() {
    return firstName.get();
  }

  public void setFirstname(String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public void setLastname(String lastName) {
    this.lastName.set(lastName);
  }

  public String getEmail() {
    return email.get();
  }

  public void setEmail(String email) {
    this.email.set(email);
  }

  public static SimpleContact dummyContact() {
    return new SimpleContact("Firstname", "Lastname","firstname.lastname@email.com");
  }
}