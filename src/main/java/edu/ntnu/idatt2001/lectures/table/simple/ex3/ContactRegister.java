package edu.ntnu.idatt2001.lectures.table.simple.ex3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents an Address book containing contacts with contact details.
 * Based on the example in the book "Objects first with Java" by David J. Barnes
 * and Michael Kölling.
 *
 * <p>Each contact is stored in a TreeMap using the phone number as the key.
 *
 * @author David J. Barnes and Michael Kölling and Arne Styve
 * @version 2020.03.16
 */
public class ContactRegister {
  private ArrayList<Contact> contactRegister = null;

  /**
   * Creates an instance of the ContactRegister, initialising the instance.
   */
  public ContactRegister() {
    contactRegister = new ArrayList<>();
  }

  /**
   * Add a new contact to the contact register.
   *
   * @param contact The contact to be added.
   */
  public void addContact(Contact contact) {
    if (contact != null) {
      contactRegister.add(contact);
    }
  }

  /**
   * Returns all the contacts as a collection.
   *
   * @return all the contacts as a collection.
   */
  public Collection<Contact> getAllContacts() {
    return this.contactRegister;
  }
}
