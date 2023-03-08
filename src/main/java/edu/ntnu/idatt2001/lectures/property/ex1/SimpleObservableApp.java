//https://www.youtube.com/watch?v=XvnJAVItaAw

package edu.ntnu.idatt2001.lectures.property.ex1;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;

public class SimpleObservableApp {

  private void noneObservable() {
    // No observable wrapper
    int a = 10;
    int b = 10;

    int c = a + b;
    System.out.println("\nNone observable:");
    
    System.out.println(String.format("value of %s + %s = %s",a,b,c));
    
    a = 30;
    System.out.println(String.format("value of %s + %s = %s",a,b,c));
  }

  private void numberObservable() {
    // observable wrapper
    SimpleIntegerProperty a = new SimpleIntegerProperty(10);
    SimpleIntegerProperty b = new SimpleIntegerProperty(10);
    NumberBinding sum = a.add(b);

    System.out.println("\nObservable numbers:");
    System.out.println(String.format("value of %s + %s = %s",a.getValue(),b.getValue(),sum.getValue()));

    a.setValue(30);

    System.out.println(String.format("value of %s + %s = %s",a.getValue(),b.getValue(),sum.getValue()));
  }

  public static void main(String... args) {
    SimpleObservableApp so = new SimpleObservableApp();
    so.noneObservable();
    so.numberObservable();
  }
}
