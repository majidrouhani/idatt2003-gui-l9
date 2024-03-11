//https://www.youtube.com/watch?v=XvnJAVItaAw

package edu.ntnu.idatt2003.lectures.property;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SimpleObservableApp {

  private void noneObservable() {
    // No observable wrapper
    int a = 10;
    int b = 10;

    int c = a + b;
    System.out.println("\nNone observable:");

    System.out.println(String.format("value of %s + %s = %s", a, b, c));

    a = 30;
    System.out.println(String.format("value of %s + %s = %s", a, b, c));
  }

  private void numberObservableEx1() {
    // observable wrapper
    IntegerProperty a = new SimpleIntegerProperty(10);
    IntegerProperty b = new SimpleIntegerProperty(10);
    NumberBinding sum = a.add(b);
    NumberBinding multiply = a.multiply(b);
    NumberBinding subtract = a.subtract(b);

    System.out.println("\nObservable numbers:");
    System.out.println(String.format("value of %s + %s = %s", a.getValue(), b.getValue(), sum.getValue()));

    a.setValue(30);

    System.out.println(String.format("value of %s + %s = %s", a.getValue(), b.getValue(), sum.getValue()));
    System.out.println(String.format("value of %s * %s = %s", a.getValue(), b.getValue(), multiply.getValue()));
    System.out.println(String.format("value of %s - %s = %s", a.getValue(), b.getValue(), subtract.getValue()));
  }

  private void numberObservableEx2() {
    // observable wrapper
    IntegerProperty a = new SimpleIntegerProperty(5);
    IntegerProperty b = new SimpleIntegerProperty(10);
    IntegerProperty c = new SimpleIntegerProperty(20);
    IntegerProperty d = new SimpleIntegerProperty(25);

    NumberBinding result = Bindings.add(Bindings.multiply(a, b), Bindings.multiply(c, d));

    System.out.println(String.format("value of (%s * %s) + (%s * %s) = %s", a.getValue(), b.getValue(), c.getValue(),
        d.getValue(), result.getValue()));

    a.setValue(7);

    System.out.println(String.format("value of (%s * %s) + (%s * %s) = %s", a.getValue(), b.getValue(), c.getValue(),
        d.getValue(), result.getValue()));
  }

  public static void main(String... args) {
    SimpleObservableApp so = new SimpleObservableApp();
    so.noneObservable();
    so.numberObservableEx1();
    so.numberObservableEx2();
  }
}
