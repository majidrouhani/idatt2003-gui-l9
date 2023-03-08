package edu.ntnu.idatt2001.lectures.table.simple.ex2;

public class Contact {

  private String firstname = null;
  private String lastname = null;
  private String primaryEmail = null;
  private String secondaryEmail = null;
  
  public Contact() {
  }

  public Contact(String firstname, String lastname, String primaryEmail, String secondaryEmail) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.primaryEmail=primaryEmail;
    this.secondaryEmail = secondaryEmail;    
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstName) {
    this.firstname = firstName;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
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