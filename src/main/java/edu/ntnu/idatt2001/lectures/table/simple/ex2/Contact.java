package edu.ntnu.idatt2001.lectures.table.simple.ex2;

public class Contact {

  private String firstName = null;
  private String lastName = null;
  private String primaryEmail = null;
  private String secondaryEmail = null;
  
  public Contact() {
  }

  public Contact(String firstName, String lastName, String primaryEmail, String secondaryEmail) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.primaryEmail=primaryEmail;
    this.secondaryEmail = secondaryEmail;    
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

  public String getSecondaryEmail() {
    return secondaryEmail;
  }

  public void setSecondaryEmail(String secondaryEmail) {
    this.secondaryEmail = secondaryEmail;
  }

  public String getPrimaryEmail() {
    return primaryEmail;
  }

  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }
}