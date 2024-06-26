package edu.ntnu.idatt2003.lectures.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeProperty {
  public static void main(String[] args) {
    int x = 100;

    // Create an observable property
    IntegerProperty counter = new SimpleIntegerProperty(x);

    // Add a change listener to the counter property
    counter.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> changed(observable, oldValue, newValue));

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
