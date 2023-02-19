package edu.ntnu.idatt2001.lectures.table.property.ex3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeProperty {
  public static void main(String[] args) {
    IntegerProperty counter = new SimpleIntegerProperty(1);

    // Add a change listener to the counter property
    counter.addListener(ChangeProperty::changed);

    System.out.println("value-11");
    counter.set(11); /* w w w .d e m o 2 s . c o m */
    System.out.println("value-11");

    System.out.println("value-12");
    counter.set(12);
    System.out.println("value-12");

    // Try setting the same value
    System.out.println("value-12");
    counter.set(12); // No change event will be fired.
    System.out.println("value-12");

    // Try setting a different value
    System.out.println("value-13");
    counter.set(13);
    System.out.println("value-13");
  }

  public static void changed(ObservableValue<? extends Number> prop, Number oldValue,
      Number newValue) {
    System.out.print("Counter changed: ");
    System.out.println("Old = " + oldValue + ", new = " + newValue);
  }
}
