
package edu.ntnu.idatt2001.lectures.dialog.optional;

import java.util.Optional;

public class ExampleOptional2 {
  public static void main(String[] args) {
    String[] str = new String[10];
    str[5] = "JAVA OPTIONAL CLASS EXAMPLE";
    Optional<String> checkNull = Optional.ofNullable(str[5]);
    checkNull.ifPresent(System.out::println);

    System.out.println(checkNull.get());
  }
}