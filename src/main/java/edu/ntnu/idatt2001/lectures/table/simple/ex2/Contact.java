package edu.ntnu.idatt2001.lectures.table.simple.ex2;

import edu.ntnu.idatt2001.lectures.table.simple.ex1.SimpleContact;

public class Contact extends SimpleContact{

  private String secondaryEmail = null;
  
  public Contact(String firstname, String lastname, String primaryEmail, String secondaryEmail) {
    super(firstname,lastname,primaryEmail);
    this.secondaryEmail = secondaryEmail;    
  }

  public String getSecondaryEmail() {
    return secondaryEmail;
  }

  public void setSecondaryEmail(String secondaryEmail) {
    this.secondaryEmail = secondaryEmail;
  }
}