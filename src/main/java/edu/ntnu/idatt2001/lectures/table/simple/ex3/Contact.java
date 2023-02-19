package edu.ntnu.idatt2001.lectures.table.simple.ex3;

public class Contact {

  private String firstName = null;
  private String lastName = null;
  private String email = null;

  public Contact() {
  }

  public Contact(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.setEmail(email);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}