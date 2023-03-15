package edu.ntnu.idatt2001.lectures.dialog.optional;


/* 
 * This example will fail since str is not initialized
 * We get nullpointer exception.
 * 
*/
public class ExampleNoOptional {
  public static void main(String[] args) {
    String[] str = new String[10];
    String lowercaseString = str[5].toLowerCase();
    System.out.print(lowercaseString);
  }
}