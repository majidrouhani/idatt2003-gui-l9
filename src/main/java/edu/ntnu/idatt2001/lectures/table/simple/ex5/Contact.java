package edu.ntnu.idatt2001.lectures.table.simple.ex5;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

  private SimpleStringProperty firstname = new SimpleStringProperty();
  private SimpleStringProperty lastname = new SimpleStringProperty();;
  private SimpleStringProperty email = new SimpleStringProperty();;

  public Contact() {
  }

  public Contact(String firstname, String lastname, String email) {
    this.firstname.setValue(firstname);
    this.lastname.setValue(lastname);
    this.email.setValue(email);
  }

  public String getFirstname() {
    return this.firstname.getValue();
  }

  public void setFirstname(String firstname) {
    this.firstname.setValue(firstname);
  }

  public String getLastname() {
    return lastname.getValue();
  }

  public void setLastname(String lastname) {
    this.lastname.setValue(lastname);
  }

  public String getEmail() {
    return email.getValue();
  }

  public void setEmail(String email) {
    this.email.setValue(email);
  }
}