package edu.ntnu.idatt2001.lectures.property.ex2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeProperty {
  public static void main(String[] args) {
    int x = 100;

    IntegerProperty counter = new SimpleIntegerProperty(x);

    // Add a change listener to the counter property
    counter.addListener(ChangeProperty::changed);

    System.out.println(x);
    counter.set(x);
    System.out.println(x);

    //Change value
    x++;
    System.out.println(x);
    counter.set(x);
    System.out.println(x);

    // Try setting the same value
    System.out.println(x);
    counter.set(x); // No change event will be fired.
    System.out.println(x);

    // Try setting a different value
    x++;
    System.out.println(x);
    counter.set(x);
    System.out.println(x);
  }

  public static void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
    System.out.print("Counter changed: old = " + oldValue + ", new = " + newValue);
  }
}
