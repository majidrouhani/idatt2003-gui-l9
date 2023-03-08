package edu.ntnu.idatt2001.lectures.table.simple.ex2;

import edu.ntnu.idatt2001.lectures.table.simple.ex1.SimpleContact;
import javafx.beans.property.SimpleStringProperty;

public class Contact extends SimpleContact{

  private SimpleStringProperty secondaryEmail = new SimpleStringProperty();
  
  public Contact(String firstName, String lastName, String primaryEmail, String secondaryEmail) {
    super(firstName,lastName,primaryEmail);
    this.secondaryEmail.set(secondaryEmail);    
  }

  public String getSecondaryEmail() {
    return secondaryEmail.get();
  }

  public void setSecondaryEmail(String secondaryEmail) {
    this.secondaryEmail.set(secondaryEmail);
  }
}