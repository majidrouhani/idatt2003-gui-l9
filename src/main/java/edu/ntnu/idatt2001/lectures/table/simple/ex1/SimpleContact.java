package edu.ntnu.idatt2001.lectures.table.simple.ex1;

public class SimpleContact {

  private String firstname = null;
  private String lastname = null;
  private String email = null;

  public SimpleContact() {
  }

  public SimpleContact(String firstname, String lastname, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.setEmail(email);
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}