
package edu.ntnu.idatt2003.lectures.dialog.optional;

import java.util.Optional;

public class ExampleOptional {

  /*
   * In this example, Optional is used to check if a value exist using
   * 'ofNullable'
   * We then check if the Optional is present using 'isPresent'
   */
  private void ofNullable(String s) {
    Optional<String> checkNull = Optional.ofNullable(s);

    if (checkNull.isPresent()) {
      String lowercaseString = checkNull.get();
      System.out.println("The value is: " + lowercaseString);
    } else
      System.out.println("string value is not present");
  }

  /*
   * In this example, Optional is used to check if a value exist using
   * 'ofNullable'
   * We then return a default value if no value exist.
   */
  private void ofNullableDefault(String s) {
    String value = Optional.ofNullable(s).orElse("Default value");

    System.out.println("The value is: " + value);
  }

  public static void main(String[] args) {
    String[] str = new String[10];
    str[0] = "Ola Normann";

    ExampleOptional opCheck = new ExampleOptional();

    opCheck.ofNullable(str[0]);
    opCheck.ofNullable(str[5]);

    opCheck.ofNullableDefault(str[0]);
    opCheck.ofNullableDefault(str[5]);
  }
}