package edu.ntnu.idatt2003.lectures.binding;

import javafx.beans.property.SimpleStringProperty;

public class SimpleBinding {

    public static void main(String[] args) {
        SimpleStringProperty property1 = new SimpleStringProperty("Ola");
        SimpleStringProperty property2 = new SimpleStringProperty("Martin");

        System.out.println(property1.get() + " " + property2.get());
        property1.set("Kari");
        property2.set("Johansen");

        // Unidirectional binding
        property1.bind(property2);

        System.out.println(property1.get() + " " + property2.get());

        // Unbind unidirectional binding
        property1.unbind();

        // Bidirectional binding
        property2.bindBidirectional(property1);

        // change property1
        property1.set("Hans");
        System.out.println(property1.get() + " " + property2.get());

        // change property2
        property2.set("Hansen");
        System.out.println(property1.get() + " " + property2.get());
    }
}
