package edu.ntnu.idatt2003.lectures.table.simple.ex1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleContact {

  private StringProperty firstName = new SimpleStringProperty();
  private StringProperty lastName = new SimpleStringProperty();
  private StringProperty email = new SimpleStringProperty();


  public SimpleContact(String firstName, String lastName, String email) {
    this.firstName.set(firstName);
    this.lastName.set(lastName);
    this.email.set(email);
  }

  public final String getFirstName() {
    return firstName.get();
  }

  public final void setFirstname(String value) {
    this.firstName.set(value);
  }

  public final String getLastName() {
    return lastName.get();
  }

  public final void setLastname(String value) {
    this.lastName.set(value);
  }

  public final String getEmail() {
    return email.get();
  }

  public final void setEmail(String value) {
    this.email.set(value);
  }

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public StringProperty lastNameProperty() {
    return lastName;
  }

  public StringProperty emailProperty() {
    return email;
  }

  public static SimpleContact dummyContact() {
    return new SimpleContact("Dummy first name", "Dummy last name", "Dummy email");
  }
}